package remove.tanks.game.level.engine.entity.component.spawn;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;
import remove.tanks.game.level.engine.utility.spwan.entry.SpawnEntryFactory;
import remove.tanks.game.utility.random.RandomNumberGenerator;
import remove.tanks.game.utility.scale.Scale;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class RandomSpawnComponentFactory
        implements RegistrableComponentFactory<RandomSpawnComponent, RandomSpawnComponentPrototype>
{
    private final SpawnEntryFactory spawnEntryFactory;
    private final RandomNumberGenerator randomNumberGenerator;

    public RandomSpawnComponentFactory(
            SpawnEntryFactory spawnEntryFactory,
            RandomNumberGenerator randomNumberGenerator
    ) {
        this.spawnEntryFactory = spawnEntryFactory;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public RandomSpawnComponent createComponent(RandomSpawnComponentPrototype prototype, Level level, Entity entity) {
        return new RandomSpawnComponent(
                prototype.getMinSpawnFrequency(),
                prototype.getMaxSpawnFrequency(),
                new Timer(randomNumberGenerator.getRandomFloat(
                        prototype.getMinSpawnFrequency(),
                        prototype.getMaxSpawnFrequency()
                )),
                spawnEntryFactory.createSpawnEntries(
                        prototype.getSpawnEntryPrototypes(),
                        level.getResourceRegistry().getResource(LevelResource.WorldScale.toString(), Scale.class)
                )
        );
    }

    @Override
    public Class<RandomSpawnComponentPrototype> getFactoryType() {
        return RandomSpawnComponentPrototype.class;
    }
}
