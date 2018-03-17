package remove.tanks.game.level.engine.system.combat;

import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.SubEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.utility.number.random.RandomNumberGenerator;

/**
 * @author Mateusz Długosz
 */
public final class RandomShootSystemFactory implements SubEntitySystemFactory<RandomShootSystem, RandomShootSystemPrefab> {
    private final RandomNumberGenerator randomNumberGenerator;

    public RandomShootSystemFactory(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public RandomShootSystem createEntitySystem(RandomShootSystemPrefab prefab, ResourceRegistry registry) {
        try {
            return new RandomShootSystem(prefab.getPriority(), randomNumberGenerator);
        } catch (Exception e) {
            throw new EntitySystemCreateException(prefab, e);
        }
    }

    @Override
    public Class<RandomShootSystemPrefab> getFactoryType() {
        return RandomShootSystemPrefab.class;
    }
}
