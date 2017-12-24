package remove.tanks.game.level.engine.entity.component.destroy;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;

/**
 * @author Mateusz Długosz
 */
public final class DestroyOnContactComponentFactory
        implements RegistrableComponentFactory<DestroyOnContactComponent, DestroyOnContactComponentPrototype>
{
    @Override
    public DestroyOnContactComponent createComponent(DestroyOnContactComponentPrototype prototype, Level level, Entity entity) {
        try {
            return new DestroyOnContactComponent();
        } catch (Exception e) {
            throw new ComponentCreateException(prototype, e);
        }
    }

    @Override
    public Class<DestroyOnContactComponentPrototype> getFactoryType() {
        return DestroyOnContactComponentPrototype.class;
    }
}
