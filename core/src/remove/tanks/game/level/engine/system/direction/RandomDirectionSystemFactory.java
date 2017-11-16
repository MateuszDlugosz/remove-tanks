package remove.tanks.game.level.engine.system.direction;

import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.utility.random.RandomNumberGenerator;

/**
 * @author Mateusz Długosz
 */
public final class RandomDirectionSystemFactory
        implements RegistrableEntitySystemFactory<RandomDirectionSystem, RandomDirectionSystemPrototype>
{
    private final RandomNumberGenerator randomNumberGenerator;

    public RandomDirectionSystemFactory(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public RandomDirectionSystem createEntitySystem(RandomDirectionSystemPrototype prototype, ResourceRegistry resourceRegistry) {
        return new RandomDirectionSystem(randomNumberGenerator, prototype.getPriority());
    }

    @Override
    public Class<RandomDirectionSystemPrototype> getFactoryType() {
        return RandomDirectionSystemPrototype.class;
    }
}
