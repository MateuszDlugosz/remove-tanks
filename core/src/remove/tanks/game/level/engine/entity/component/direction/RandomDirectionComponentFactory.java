package remove.tanks.game.level.engine.entity.component.direction;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;
import remove.tanks.game.utility.random.RandomNumberGenerator;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class RandomDirectionComponentFactory
        implements RegistrableComponentFactory<RandomDirectionComponent, RandomDirectionComponentPrototype>
{
    private final RandomNumberGenerator randomNumberGenerator;

    public RandomDirectionComponentFactory(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public RandomDirectionComponent createComponent(RandomDirectionComponentPrototype prototype, Level level, Entity entity) {
        return new RandomDirectionComponent(
                prototype.getChangeDirectionMinFrequency(),
                prototype.getChangeDirectionMaxFrequency(),
                prototype.getAvailableDirections(),
                new Timer(
                        randomNumberGenerator.getRandomFloat(
                                prototype.getChangeDirectionMinFrequency(),
                                prototype.getChangeDirectionMaxFrequency()
                        )
                )
        );
    }

    @Override
    public Class<RandomDirectionComponentPrototype> getFactoryType() {
        return RandomDirectionComponentPrototype.class;
    }
}
