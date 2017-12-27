package remove.tanks.game.level.engine.system.shoot;

import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.utility.random.RandomNumberGenerator;

/**
 * @author Mateusz Długosz
 */
public final class RandomShootSystemFactory
        implements RegistrableEntitySystemFactory<RandomShootSystem, RandomShootSystemPrototype>
{
    private final RandomNumberGenerator randomNumberGenerator;

    public RandomShootSystemFactory(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public RandomShootSystem createEntitySystem(RandomShootSystemPrototype prototype, ResourceRegistry resourceRegistry) {
        try {
            return new RandomShootSystem(
                    prototype.getPriority(),
                    randomNumberGenerator
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prototype, e);
        }
    }

    @Override
    public Class<RandomShootSystemPrototype> getFactoryType() {
        return RandomShootSystemPrototype.class;
    }
}
