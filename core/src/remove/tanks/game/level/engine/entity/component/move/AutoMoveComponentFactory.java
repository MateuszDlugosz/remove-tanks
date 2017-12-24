package remove.tanks.game.level.engine.entity.component.move;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;

/**
 * @author Mateusz Długosz
 */
public final class AutoMoveComponentFactory
        implements RegistrableComponentFactory<AutoMoveComponent, AutoMoveComponentPrototype>
{
    @Override
    public AutoMoveComponent createComponent(AutoMoveComponentPrototype prototype, Level level, Entity entity) {
        try {
            return new AutoMoveComponent();
        } catch (Exception e) {
            throw new ComponentCreateException(prototype, e);
        }
    }

    @Override
    public Class<AutoMoveComponentPrototype> getFactoryType() {
        return AutoMoveComponentPrototype.class;
    }
}
