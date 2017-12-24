package remove.tanks.game.level.engine.entity.component.layer;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;

/**
 * @author Mateusz Długosz
 */
public final class ExplosionLayerComponentFactory
        implements RegistrableComponentFactory<ExplosionLayerComponent, ExplosionLayerComponentPrototype>
{
    @Override
    public ExplosionLayerComponent createComponent(ExplosionLayerComponentPrototype prototype, Level level, Entity entity) {
        try {
            return new ExplosionLayerComponent();
        } catch (Exception e) {
            throw new ComponentCreateException(prototype, e);
        }
    }

    @Override
    public Class<ExplosionLayerComponentPrototype> getFactoryType() {
        return ExplosionLayerComponentPrototype.class;
    }
}
