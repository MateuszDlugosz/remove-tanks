package remove.tanks.game.level.engine.system.spawn;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.utils.ImmutableArray;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.EntityPrototype;
import remove.tanks.game.level.engine.entity.EntityPrototypeRepository;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;
import remove.tanks.game.level.engine.entity.component.spawn.AutoSpawnerComponent;
import remove.tanks.game.level.engine.utility.spawn.spawner.Spawner;
import remove.tanks.game.level.event.destroy.DestroyEntityEvent;
import remove.tanks.game.level.event.spawn.SpawnEntityEvent;
import remove.tanks.game.physics.fixture.sensor.Sensor;
import remove.tanks.game.utility.random.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class AutoSpawnerSystem extends EntitySystem {
    private final RandomNumberGenerator randomNumberGenerator;
    private final EntityPrototypeRepository repository;
    private final EventBus eventBus;
    private final List<String> spawnersToDeactivate;
    private final Map<String, Spawner> inactiveSpawners;
    private final Map<String, Spawner> activeSpawners;

    public AutoSpawnerSystem(
            int priority,
            RandomNumberGenerator randomNumberGenerator,
            EntityPrototypeRepository repository,
            EventBus eventBus,
            Map<String, Spawner> inactiveSpawners,
            Map<String, Spawner> activeSpawners
    ) {
        super(priority);
        this.inactiveSpawners = inactiveSpawners;
        this.repository = repository;
        this.eventBus = eventBus;
        this.activeSpawners = activeSpawners;
        this.randomNumberGenerator = randomNumberGenerator;
        this.spawnersToDeactivate = new ArrayList<>();
    }

    public void activateSpawner(String id) {
        if (inactiveSpawners.containsKey(id)) {
            activeSpawners.put(id, inactiveSpawners.remove(id));
        }
    }

    @Override
    public void update(float deltaTime) {
        activeSpawners.values().forEach(s -> {
            if (s.getTimer().isCompleted()) {
                if (spawnEntity(s)) {
                    s.getCounter().update();
                    if (s.getCounter().isComplete()) {
                        spawnersToDeactivate.add(s.getId());
                    }
                }
                s.getTimer().reset();
            } else {
                s.getTimer().update(deltaTime);
            }
        });
        spawnersToDeactivate.forEach(this::deactivateSpawner);
        spawnersToDeactivate.clear();
    }

    private boolean spawnEntity(Spawner spawner) {
        EntityPrototype prototype = repository.getPrototype(spawner.getPrototypeCodes().get(
                randomNumberGenerator.getRandomInt(0, spawner.getPrototypeCodes().size()-1)
        ));
        List<Entity> spawners = getSpawnersEntitiesForLetter(spawner.getId());
        if (spawners.size() > 0) {
            Entity entity = getRandomSpawnerEntity(spawners);
            PhysicsComponent pc = PhysicsComponent.MAPPER.get(entity);
            for (Sensor sensor : pc.getSensors().values()) {
                if (sensor.isContacted()) return false;
            }
            eventBus.post(new SpawnEntityEvent(prototype, pc.getPosition()));
            return true;
        }
        return false;
    }

    private List<Entity> getSpawnersEntitiesForLetter(String id) {
        List<Entity> spawners = new ArrayList<>();
        ImmutableArray<Entity> allSpawners
                = getEngine().getEntitiesFor(EntityFamily.SpawnerFamily.getFamily());
        allSpawners.forEach(s -> {
            if (AutoSpawnerComponent.MAPPER.get(s).getId().equals(id)) {
                spawners.add(s);
            }
        });
        return spawners;
    }

    private Entity getRandomSpawnerEntity(List<Entity> entities) {
        return entities.get(randomNumberGenerator.getRandomInt(
                0, entities.size()-1
        ));
    }

    private void deactivateSpawner(String id) {
        getEngine().getEntitiesFor(EntityFamily.SpawnerFamily.getFamily()).forEach(
                e -> {
                    if (AutoSpawnerComponent.MAPPER.get(e).getId().equals(id)) {
                        eventBus.post(new DestroyEntityEvent(e));
                    }
                });
        inactiveSpawners.remove(id);
        activeSpawners.remove(id);
    }
}
