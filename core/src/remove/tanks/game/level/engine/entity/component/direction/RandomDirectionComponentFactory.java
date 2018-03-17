package remove.tanks.game.level.engine.entity.component.direction;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.utility.number.random.RandomNumberGenerator;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class RandomDirectionComponentFactory implements SubComponentFactory<RandomDirectionComponent, RandomDirectionComponentPrefab> {
    private final RandomNumberGenerator randomNumberGenerator;

    public RandomDirectionComponentFactory(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public RandomDirectionComponent createComponent(RandomDirectionComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new RandomDirectionComponent(
                    prefab.getMinChangeDirectionFrequency(),
                    prefab.getMaxChangeDirectionFrequency(),
                    prefab.getDirections(),
                    createTimer(
                            prefab.getMinChangeDirectionFrequency(),
                            prefab.getMaxChangeDirectionFrequency()
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
    public Class<RandomDirectionComponentPrefab> getFactoryType() {
        return RandomDirectionComponentPrefab.class;
    }
}
