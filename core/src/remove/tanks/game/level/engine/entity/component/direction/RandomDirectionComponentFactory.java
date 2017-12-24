package remove.tanks.game.level.engine.entity.component.direction;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
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
        try {
            return new RandomDirectionComponent(
                    prototype.getChangeDirectionMinFrequency(),
                    prototype.getChangeDirectionMaxFrequency(),
                    prototype.getAvailableDirections(),
                    createTimer(
                            prototype.getChangeDirectionMinFrequency(),
                            prototype.getChangeDirectionMaxFrequency()
                    )
            );
        } catch (Exception e) {
            throw new ComponentCreateException(prototype, e);
        }
    }

    private Timer createTimer(float min, float max) {
        return new Timer(randomNumberGenerator.getRandomFloat(min, max));
    }

    @Override
    public Class<RandomDirectionComponentPrototype> getFactoryType() {
        return RandomDirectionComponentPrototype.class;
    }
}
