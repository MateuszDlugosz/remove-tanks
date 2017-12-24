package remove.tanks.game.level.engine.entity.component.direction;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;

/**
 * @author Mateusz Długosz
 */
public final class DirectionComponentFactory
        implements RegistrableComponentFactory<DirectionComponent, DirectionComponentPrototype>
{
    @Override
    public DirectionComponent createComponent(DirectionComponentPrototype prototype, Level level, Entity entity) {
        try {
            return new DirectionComponent(prototype.getDirection());
        } catch (Exception e) {
            throw new ComponentCreateException(prototype, e);
        }
    }

    @Override
    public Class<DirectionComponentPrototype> getFactoryType() {
        return DirectionComponentPrototype.class;
    }
}
