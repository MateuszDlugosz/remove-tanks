package remove.tanks.game.level.engine.entity.component.layer;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;

/**
 * @author Mateusz Długosz
 */
public final class BulletLayerComponentFactory
        implements RegistrableComponentFactory<BulletLayerComponent, BulletLayerComponentPrototype>
{
    @Override
    public BulletLayerComponent createComponent(BulletLayerComponentPrototype prototype, Level level, Entity entity) {
        try {
            return new BulletLayerComponent();
        } catch (Exception e) {
            throw new ComponentCreateException(prototype, e);
        }
    }

    @Override
    public Class<BulletLayerComponentPrototype> getFactoryType() {
        return BulletLayerComponentPrototype.class;
    }
}
