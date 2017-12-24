package remove.tanks.game.level.engine.listener.trigger;

import com.badlogic.ashley.core.Engine;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.listener.EntityListenerCreateException;
import remove.tanks.game.level.engine.listener.RegistrableEntityListenerFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class TriggerListenerFactory
        implements RegistrableEntityListenerFactory<TriggerListener, TriggerListenerPrototype>
{
    @Override
    public TriggerListener createEntityListener(TriggerListenerPrototype prototype, ResourceRegistry registry, Engine engine) {
        try {
            return new TriggerListener(
                    prototype.getPriority(),
                    engine,
                    registry.getResource(LevelResource.EventBus.toString(), EventBus.class)
            );
        } catch (Exception e) {
            throw new EntityListenerCreateException(prototype, e);
        }
    }

    @Override
    public Class<TriggerListenerPrototype> getFactoryType() {
        return TriggerListenerPrototype.class;
    }
}
