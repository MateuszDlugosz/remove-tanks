package remove.tanks.game.level.engine.entity.component.layer;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;

/**
 * @author Mateusz Długosz
 */
public final class BombLayerComponentFactory
        implements RegistrableComponentFactory<BombLayerComponent, BombLayerComponentPrototype>
{
    @Override
    public BombLayerComponent createComponent(BombLayerComponentPrototype prototype, Level level, Entity entity) {
        try {
            return new BombLayerComponent();
        } catch (Exception e) {
            throw new ComponentCreateException(prototype, e);
        }
    }

    @Override
    public Class<BombLayerComponentPrototype> getFactoryType() {
        return BombLayerComponentPrototype.class;
    }
}
