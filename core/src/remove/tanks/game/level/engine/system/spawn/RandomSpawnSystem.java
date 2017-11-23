package remove.tanks.game.level.engine.system.spawn;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.systems.IteratingSystem;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.EntityPrototypeRepository;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;
import remove.tanks.game.level.engine.entity.component.spawn.RandomSpawnComponent;
import remove.tanks.game.level.engine.utility.spwan.entry.SpawnEntry;
import remove.tanks.game.level.event.spawn.SpawnEntityEvent;
import remove.tanks.game.utility.random.RandomNumberGenerator;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class RandomSpawnSystem extends IteratingSystem {
    private final RandomNumberGenerator randomNumberGenerator;
    private final EventBus eventBus;
    private final EntityPrototypeRepository entityPrototypeRepository;

    public RandomSpawnSystem(
            int priority,
            RandomNumberGenerator randomNumberGenerator,
            EventBus eventBus,
            EntityPrototypeRepository entityPrototypeRepository
    ) {
        super(EntityFamily.RandomSpawnFamily.getFamily(), priority);
        this.randomNumberGenerator = randomNumberGenerator;
        this.eventBus = eventBus;
        this.entityPrototypeRepository = entityPrototypeRepository;
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        RandomSpawnComponent rsc = RandomSpawnComponent.MAPPER.get(entity);
        if (rsc.getTimer().isComplete()) {
            SpawnEntry spawnEntry = rsc.getSpawnEntries().get(
                    randomNumberGenerator.getRandomInt(0, rsc.getSpawnEntries().size()-1)
            );
            eventBus.post(new SpawnEntityEvent(
                    entityPrototypeRepository.getPrototype(spawnEntry.getPrototypeCode()),
                    PhysicsComponent.MAPPER.get(entity).getPosition().sum(spawnEntry.getPosition())
            ));
            entity.add(new RandomSpawnComponent(
                    rsc.getMinSpawnFrequency(),
                    rsc.getMaxSpawnFrequency(),
                    new Timer(randomNumberGenerator.getRandomFloat(
                            rsc.getMinSpawnFrequency(),
                            rsc.getMaxSpawnFrequency()
                    )),
                    rsc.getSpawnEntries()
            ));
        } else rsc.getTimer().update(deltaTime);
    }
}
