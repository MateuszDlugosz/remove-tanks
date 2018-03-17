package remove.tanks.game.level.engine.system.direction;

import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.SubEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.utility.number.random.RandomNumberGenerator;

/**
 * @author Mateusz Długosz
 */
public final class RandomDirectionSystemFactory implements SubEntitySystemFactory<RandomDirectionSystem, RandomDirectionSystemPrefab> {
    private final RandomNumberGenerator randomNumberGenerator;

    public RandomDirectionSystemFactory(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public RandomDirectionSystem createEntitySystem(RandomDirectionSystemPrefab prefab, ResourceRegistry registry) {
        try {
            return new RandomDirectionSystem(
                    prefab.getPriority(),
                    randomNumberGenerator
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prefab, e);
        }
    }

    @Override
    public Class<RandomDirectionSystemPrefab> getFactoryType() {
        return RandomDirectionSystemPrefab.class;
    }
}
