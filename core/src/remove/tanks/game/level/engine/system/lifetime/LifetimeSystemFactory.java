package remove.tanks.game.level.engine.system.lifetime;

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
        return new LifetimeSystem(prototype.getPriority());
    }

    @Override
    public Class<LifetimeSystemPrototype> getFactoryType() {
        return LifetimeSystemPrototype.class;
    }
}
