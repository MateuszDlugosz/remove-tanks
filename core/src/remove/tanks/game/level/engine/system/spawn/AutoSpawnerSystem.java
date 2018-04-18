package remove.tanks.game.level.engine.system.spawn;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.utils.ImmutableArray;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;
import remove.tanks.game.level.engine.entity.component.spawn.AutoSpawnerComponent;
import remove.tanks.game.level.event.create.CreateEvent;
import remove.tanks.game.level.event.entity.destroy.DestroyEntityEvent;
import remove.tanks.game.level.utility.create.CreateEntry;
import remove.tanks.game.level.utility.spawner.Spawner;
import remove.tanks.game.physics.fixture.sensor.Sensor;
import remove.tanks.game.utility.number.random.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class AutoSpawnerSystem extends EntitySystem {
    private final RandomNumberGenerator randomNumberGenerator;
    private final EventBus eventBus;
    private final List<String> spawnersToDeactivate;
    private final Map<String, Spawner> activeSpawners;
    private final Map<String, Spawner> inactiveSpawners;

    public AutoSpawnerSystem(
            int priority,
            RandomNumberGenerator randomNumberGenerator,
            EventBus eventBus,
            Map<String, Spawner> activeSpawners,
            Map<String, Spawner> inactiveSpawners
    ) {
        super(priority);
        this.randomNumberGenerator = randomNumberGenerator;
        this.eventBus = eventBus;
        this.spawnersToDeactivate = new ArrayList<>();
        this.activeSpawners = activeSpawners;
        this.inactiveSpawners = inactiveSpawners;
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
                    if (s.getCounter().isCompleted()) {
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
        List<Entity> spawners = getSpawnersEntitiesForId(spawner.getId());
        if (spawners.size() > 0) {
            Entity entity = getRandomSpawnerEntity(spawners);
            PhysicsComponent pc = PhysicsComponent.MAPPER.get(entity);
            for (Sensor sensor : pc.getSensors().values()) {
                if (sensor.isContacted()) return false;
            }
            eventBus.post(new CreateEvent(Collections.singletonList(
                    new CreateEntry(getRandomPrefabCode(spawner), pc.getPosition()))));
            return true;
        }
        return false;
    }

    private String getRandomPrefabCode(Spawner spawner) {
        return spawner.getEntityPrefabCodes().get(randomNumberGenerator
                .getRandomInt(0, spawner.getEntityPrefabCodes().size() - 1));
    }

    private List<Entity> getSpawnersEntitiesForId(String id) {
        List<Entity> spawners = new ArrayList<>();
        ImmutableArray<Entity> allSpawners
                = getEngine().getEntitiesFor(EntityFamily.AutoSpawnerFamily.getFamily());
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
        getEngine().getEntitiesFor(EntityFamily.AutoSpawnerFamily.getFamily()).forEach(
                e -> {
                    if (AutoSpawnerComponent.MAPPER.get(e).getId().equals(id)) {
                        eventBus.post(new DestroyEntityEvent(e));
                    }
                });
        inactiveSpawners.remove(id);
        activeSpawners.remove(id);
    }
}
