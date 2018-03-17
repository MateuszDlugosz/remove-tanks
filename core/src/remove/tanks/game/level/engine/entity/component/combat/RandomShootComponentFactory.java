package remove.tanks.game.level.engine.entity.component.combat;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.utility.number.random.RandomNumberGenerator;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class RandomShootComponentFactory implements SubComponentFactory<RandomShootComponent, RandomShootComponentPrefab> {
    private final RandomNumberGenerator randomNumberGenerator;

    public RandomShootComponentFactory(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public RandomShootComponent createComponent(RandomShootComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new RandomShootComponent(
                    prefab.getMinShootFrequency(),
                    prefab.getMaxShootFrequency(),
                    createTimer(
                            prefab.getMinShootFrequency(),
                            prefab.getMaxShootFrequency()
                    )
            );
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    private Timer createTimer(float min, float max) {
        return new Timer(randomNumberGenerator.getRandomFloat(min, max));
    }

    @Override
    public Class<RandomShootComponentPrefab> getFactoryType() {
        return RandomShootComponentPrefab.class;
    }
}
