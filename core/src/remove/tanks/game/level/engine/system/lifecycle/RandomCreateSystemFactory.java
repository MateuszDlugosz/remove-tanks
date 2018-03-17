package remove.tanks.game.level.engine.system.lifecycle;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.SubEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.utility.number.random.RandomNumberGenerator;

/**
 * @author Mateusz Długosz
 */
public final class RandomCreateSystemFactory implements SubEntitySystemFactory<RandomCreateSystem, RandomCreateSystemPrefab> {
    private final RandomNumberGenerator randomNumberGenerator;

    public RandomCreateSystemFactory(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public RandomCreateSystem createEntitySystem(RandomCreateSystemPrefab prefab, ResourceRegistry registry) {
        try {
            return new RandomCreateSystem(
                    prefab.getPriority(),
                    registry.getResource(ResourceType.EventBusResource, EventBus.class),
                    randomNumberGenerator
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prefab, e);
        }
    }

    @Override
    public Class<RandomCreateSystemPrefab> getFactoryType() {
        return RandomCreateSystemPrefab.class;
    }
}
