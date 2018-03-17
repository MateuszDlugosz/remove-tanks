package remove.tanks.game.level.engine.listener.bonus;

import com.badlogic.ashley.core.Engine;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.engine.listener.EntityListenerCreateException;
import remove.tanks.game.level.engine.listener.SubEntityListenerFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.utility.number.random.RandomNumberGenerator;

/**
 * @author Mateusz Długosz
 */
public final class LeaveBonusListenerFactory implements SubEntityListenerFactory<LeaveBonusListener, LeaveBonusListenerPrefab> {
    private final RandomNumberGenerator randomNumberGenerator;

    public LeaveBonusListenerFactory(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public LeaveBonusListener createEntityListener(LeaveBonusListenerPrefab prefab, ResourceRegistry registry, Engine engine) {
        try {
            return new LeaveBonusListener(
                    prefab.getPriority(),
                    engine,
                    randomNumberGenerator,
                    registry.getResource(ResourceType.EventBusResource, EventBus.class),
                    prefab.getPrefabCodes(),
                    prefab.getChance()
            );
        } catch (Exception e) {
            throw new EntityListenerCreateException(prefab, e);
        }
    }

    @Override
    public Class<LeaveBonusListenerPrefab> getFactoryType() {
        return LeaveBonusListenerPrefab.class;
    }
}
