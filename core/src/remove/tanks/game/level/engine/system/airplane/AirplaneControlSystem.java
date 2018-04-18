package remove.tanks.game.level.engine.system.airplane;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.utils.ImmutableArray;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;
import remove.tanks.game.level.engine.entity.component.spawn.AirplaneSpawnerComponent;
import remove.tanks.game.level.event.create.CreateEvent;
import remove.tanks.game.level.utility.create.CreateEntry;
import remove.tanks.game.utility.number.random.RandomNumberGenerator;

import java.util.Collections;
import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public final class AirplaneControlSystem extends EntitySystem {
    private final RandomNumberGenerator randomNumberGenerator;
    private final EventBus eventBus;
    private int spawnQueue;

    public AirplaneControlSystem(RandomNumberGenerator randomNumberGenerator, EventBus eventBus) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.eventBus = eventBus;
        this.spawnQueue = 0;
    }

    public void spawnAirplane() {
        spawnQueue++;
    }

    @Override
    public void update(float deltaTime) {
        spawnAirplanes();
    }

    private void spawnAirplanes() {
        if (spawnQueue > 0) {
            ImmutableArray<Entity> spawners = getAirplaneSpawners();
            for (int i = 0; i < spawnQueue; i++) {
                Optional.ofNullable(getRandomAirplaneSpawner(spawners)).ifPresent(s -> {
                    eventBus.post(new CreateEvent(Collections.singletonList(new CreateEntry(
                            AirplaneSpawnerComponent.MAPPER.get(s).getEntityPrefabCode(),
                            PhysicsComponent.MAPPER.get(s).getPosition()
                    ))));
                    spawnQueue -= 1;
                });
            }
        }
    }

    private ImmutableArray<Entity> getAirplaneSpawners() {
        return getEngine().getEntitiesFor(EntityFamily.AirplaneSpawnerFamily.getFamily());
    }

    private Entity getRandomAirplaneSpawner(ImmutableArray<Entity> entities) {
        if (entities.size() == 0) return null;
        return entities.get(randomNumberGenerator.getRandomInt(0, entities.size() - 1));
    }
}
