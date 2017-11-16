package remove.tanks.game.level.engine.system.destroy;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.constant.LevelResource;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class DestroySystemFactory
        implements RegistrableEntitySystemFactory<DestroySystem, DestroySystemPrototype>
{
    @Override
    public DestroySystem createEntitySystem(DestroySystemPrototype prototype, ResourceRegistry resourceRegistry) {
        return new DestroySystem(
                resourceRegistry.getResource(LevelResource.EventBus.toString(), EventBus.class),
                prototype.getPriority()
        );
    }

    @Override
    public Class<DestroySystemPrototype> getFactoryType() {
        return DestroySystemPrototype.class;
    }
}
