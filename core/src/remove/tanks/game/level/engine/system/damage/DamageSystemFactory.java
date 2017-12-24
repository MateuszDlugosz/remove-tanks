package remove.tanks.game.level.engine.system.damage;

import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class DamageSystemFactory
        implements RegistrableEntitySystemFactory<DamageSystem, DamageSystemPrototype>
{
    @Override
    public DamageSystem createEntitySystem(DamageSystemPrototype prototype, ResourceRegistry resourceRegistry) {
        try {
            return new DamageSystem(
                    prototype.getPriority(),
                    prototype.getHitHighlightTime()
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prototype, e);
        }
    }

    @Override
    public Class<DamageSystemPrototype> getFactoryType() {
        return DamageSystemPrototype.class;
    }
}
