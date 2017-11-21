package remove.tanks.game.level.engine.entity.component.shoot;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;

/**
 * @author Mateusz Długosz
 */
public final class AmmoComponentFactory
        implements RegistrableComponentFactory<AmmoComponent, AmmoComponentPrototype>
{
    @Override
    public AmmoComponent createComponent(AmmoComponentPrototype prototype, Level level, Entity entity) {
        return new AmmoComponent(
                prototype.getCurrentLevel(),
                prototype.getMaxLevel(),
                prototype.getPrototypeCodes()
        );
    }

    @Override
    public Class<AmmoComponentPrototype> getFactoryType() {
        return AmmoComponentPrototype.class;
    }
}
