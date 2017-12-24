package remove.tanks.game.level.engine.system.lifetime;

import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class LifetimeSystemFactory
        implements RegistrableEntitySystemFactory<LifetimeSystem, LifetimeSystemPrototype>
{
    @Override
    public LifetimeSystem createEntitySystem(LifetimeSystemPrototype prototype, ResourceRegistry resourceRegistry) {
        try {
            return new LifetimeSystem(prototype.getPriority());
        } catch (Exception e) {
            throw new EntitySystemCreateException(prototype, e);
        }
    }

    @Override
    public Class<LifetimeSystemPrototype> getFactoryType() {
        return LifetimeSystemPrototype.class;
    }
}
