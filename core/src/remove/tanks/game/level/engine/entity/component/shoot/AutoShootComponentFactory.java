package remove.tanks.game.level.engine.entity.component.shoot;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;

/**
 * @author Mateusz Długosz
 */
public final class AutoShootComponentFactory
        implements RegistrableComponentFactory<AutoShootComponent, AutoShootComponentPrototype>
{
    @Override
    public AutoShootComponent createComponent(AutoShootComponentPrototype prototype, Level level, Entity entity) {
        try {
            return new AutoShootComponent();
        } catch (Exception e) {
            throw new ComponentCreateException(prototype, e);
        }
    }

    @Override
    public Class<AutoShootComponentPrototype> getFactoryType() {
        return AutoShootComponentPrototype.class;
    }
}
