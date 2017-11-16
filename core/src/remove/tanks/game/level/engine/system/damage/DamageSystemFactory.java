package remove.tanks.game.level.engine.system.damage;

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
        return new DamageSystem(prototype.getHitHighlightTime(), prototype.getPriority());
    }

    @Override
    public Class<DamageSystemPrototype> getFactoryType() {
        return DamageSystemPrototype.class;
    }
}
