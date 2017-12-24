package remove.tanks.game.level.engine.entity.component.spawn;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;
import remove.tanks.game.level.engine.utility.spawn.entry.SpawnEntry;
import remove.tanks.game.level.engine.utility.spawn.entry.SpawnEntryFactory;
import remove.tanks.game.level.engine.utility.spawn.entry.SpawnEntryPrototype;
import remove.tanks.game.utility.random.RandomNumberGenerator;
import remove.tanks.game.utility.scale.Scale;
import remove.tanks.game.utility.time.Timer;

import java.util.List;

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
        try {
            return new RandomSpawnComponent(
                    prototype.getMinSpawnFrequency(),
                    prototype.getMaxSpawnFrequency(),
                    createTimer(
                            prototype.getMinSpawnFrequency(),
                            prototype.getMaxSpawnFrequency()
                    ),
                    createSpawnEntries(
                            prototype.getSpawnEntryPrototypes(),
                            level.getResourceRegistry().getResource(
                                    LevelResource.WorldScale.toString(), Scale.class)
                    )
            );
        } catch (Exception e) {
            throw new ComponentCreateException(prototype, e);
        }
    }

    private Timer createTimer(float min, float max) {
        return new Timer(randomNumberGenerator.getRandomFloat(min, max));
    }

    private List<SpawnEntry> createSpawnEntries(List<SpawnEntryPrototype> prototypes, Scale scale) {
        return spawnEntryFactory.createSpawnEntries(prototypes, scale);
    }

    @Override
    public Class<RandomSpawnComponentPrototype> getFactoryType() {
        return RandomSpawnComponentPrototype.class;
    }
}
