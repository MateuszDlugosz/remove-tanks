package remove.tanks.game.level.engine.system.destroy;

import remove.tanks.game.level.engine.system.EntitySystemCreateException;
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
        try {
            return new DestroyOnContactSystem(
                    prototype.getPriority()
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prototype, e);
        }
    }

    @Override
    public Class<DestroyOnContactSystemPrototype> getFactoryType() {
        return DestroyOnContactSystemPrototype.class;
    }
}
