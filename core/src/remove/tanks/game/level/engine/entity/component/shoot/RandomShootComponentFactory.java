package remove.tanks.game.level.engine.entity.component.shoot;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;
import remove.tanks.game.utility.properties.Properties;
import remove.tanks.game.utility.random.RandomNumberGenerator;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class RandomShootComponentFactory
        implements RegistrableComponentFactory<RandomShootComponent, RandomShootComponentPrototype>
{
    private final RandomNumberGenerator randomNumberGenerator;

    public RandomShootComponentFactory(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public RandomShootComponent createComponent(RandomShootComponentPrototype prototype, Level level, Entity entity) {
        return new RandomShootComponent(
                prototype.getMinShootFrequency(),
                prototype.getMaxShootFrequency(),
                new Timer(randomNumberGenerator.getRandomFloat(
                        prototype.getMinShootFrequency(),
                        prototype.getMaxShootFrequency()
                ))
        );
    }

    @Override
    public Class<RandomShootComponentPrototype> getFactoryType() {
        return RandomShootComponentPrototype.class;
    }
}
