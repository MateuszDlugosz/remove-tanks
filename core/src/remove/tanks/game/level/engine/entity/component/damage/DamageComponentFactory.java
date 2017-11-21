package remove.tanks.game.level.engine.entity.component.damage;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;

/**
 * @author Mateusz Długosz
 */
public final class DamageComponentFactory
        implements RegistrableComponentFactory<DamageComponent, DamageComponentPrototype>
{
    @Override
    public DamageComponent createComponent(DamageComponentPrototype prototype, Level level, Entity entity) {
        return new DamageComponent(prototype.getDamage());
    }

    @Override
    public Class<DamageComponentPrototype> getFactoryType() {
        return DamageComponentPrototype.class;
    }
}
