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
import remove.tanks.game.level.engine.event.DestroyEntityEvent;
import remove.tanks.game.level.engine.event.SpawnEntityEvent;
import remove.tanks.game.level.engine.utility.letter.NATOLetter;
import remove.tanks.game.level.engine.utility.spwan.spawner.Spawner;
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
    private final List<NATOLetter> spawnersToDeactivate;
    private final Map<NATOLetter, Spawner> inactiveSpawners;
    private final Map<NATOLetter, Spawner> activeSpawners;

    public AutoSpawnerSystem(
            RandomNumberGenerator randomNumberGenerator,
            EntityPrototypeRepository repository,
            EventBus eventBus,
            Map<NATOLetter, Spawner> inactiveSpawners,
            Map<NATOLetter, Spawner> activeSpawners,
            int priority
    ) {
        super(priority);
        this.inactiveSpawners = inactiveSpawners;
        this.repository = repository;
        this.eventBus = eventBus;
        this.activeSpawners = activeSpawners;
        this.randomNumberGenerator = randomNumberGenerator;
        this.spawnersToDeactivate = new ArrayList<>();
    }

    public void activateSpawner(NATOLetter letter) {
        if (inactiveSpawners.containsKey(letter)) {
            activeSpawners.put(letter, inactiveSpawners.remove(letter));
        }
    }

    @Override
    public void update(float deltaTime) {
        activeSpawners.values().forEach(s -> {
            if (s.getTimer().isComplete()) {
                if (spawnEntity(s)) {
                    s.getCounter().update();
                    if (s.getCounter().isComplete()) {
                        spawnersToDeactivate.add(s.getLetter());
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
        List<Entity> spawners = getSpawnersEntitiesForLetter(spawner.getLetter());
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

    private List<Entity> getSpawnersEntitiesForLetter(NATOLetter letter) {
        List<Entity> spawners = new ArrayList<>();
        ImmutableArray<Entity> allSpawners
                = getEngine().getEntitiesFor(EntityFamily.SpawnerFamily.getFamily());
        allSpawners.forEach(s -> {
            if (AutoSpawnerComponent.MAPPER.get(s).getLetter() == letter) {
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

    private void deactivateSpawner(NATOLetter letter) {
        getEngine().getEntitiesFor(EntityFamily.SpawnerFamily.getFamily()).forEach(
                e -> {
                    if (AutoSpawnerComponent.MAPPER.get(e).getLetter().equals(letter)) {
                        eventBus.post(new DestroyEntityEvent(e));
                    }
                });
        inactiveSpawners.remove(letter);
        activeSpawners.remove(letter);
    }
}
