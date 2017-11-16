package remove.tanks.game.level.engine.system.destroy;

import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class DestroyOnContactSystemFactory
        implements RegistrableEntitySystemFactory<DestroyOnContactSystem, DestroyOnContactSystemPrototype>
{
    @Override
    public DestroyOnContactSystem createEntitySystem(DestroyOnContactSystemPrototype prototype, ResourceRegistry resourceRegistry) {
        return new DestroyOnContactSystem(
                prototype.getPriority()
        );
    }

    @Override
    public Class<DestroyOnContactSystemPrototype> getFactoryType() {
        return DestroyOnContactSystemPrototype.class;
    }
}
