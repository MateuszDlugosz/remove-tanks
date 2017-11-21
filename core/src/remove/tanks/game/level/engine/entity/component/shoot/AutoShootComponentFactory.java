package remove.tanks.game.level.engine.entity.component.shoot;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;

/**
 * @author Mateusz Długosz
 */
public final class AutoShootComponentFactory
        implements RegistrableComponentFactory<AutoShootComponent, AutoShootComponentPrototype>
{
    @Override
    public AutoShootComponent createComponent(AutoShootComponentPrototype prototype, Level level, Entity entity) {
        return new AutoShootComponent();
    }

    @Override
    public Class<AutoShootComponentPrototype> getFactoryType() {
        return AutoShootComponentPrototype.class;
    }
}
