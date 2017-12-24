package remove.tanks.game.level.engine.entity.component.destroy;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;

/**
 * @author Mateusz Długosz
 */
public final class DestroyComponentFactory
        implements RegistrableComponentFactory<DestroyComponent, DestroyComponentPrototype>
{
    @Override
    public DestroyComponent createComponent(DestroyComponentPrototype prototype, Level level, Entity entity) {
        try {
            return new DestroyComponent();
        } catch (Exception e) {
            throw new ComponentCreateException(prototype, e);
        }
    }

    @Override
    public Class<DestroyComponentPrototype> getFactoryType() {
        return DestroyComponentPrototype.class;
    }
}
