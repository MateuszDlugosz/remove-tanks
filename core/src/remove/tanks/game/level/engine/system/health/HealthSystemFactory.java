package remove.tanks.game.level.engine.system.health;

import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class HealthSystemFactory
        implements RegistrableEntitySystemFactory<HealthSystem, HealthSystemPrototype>
{
    @Override
    public HealthSystem createEntitySystem(HealthSystemPrototype prototype, ResourceRegistry resourceRegistry) {
        try {
            return new HealthSystem(prototype.getPriority());
        } catch (Exception e) {
            throw new EntitySystemCreateException(prototype, e);
        }
    }

    @Override
    public Class<HealthSystemPrototype> getFactoryType() {
        return HealthSystemPrototype.class;
    }
}
