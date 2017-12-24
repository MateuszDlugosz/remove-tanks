package remove.tanks.game.level.engine.entity.component.layer;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;

/**
 * @author Mateusz Długosz
 */
public final class GroundLayerComponentFactory
        implements RegistrableComponentFactory<GroundLayerComponent, GroundLayerComponentPrototype>
{
    @Override
    public GroundLayerComponent createComponent(GroundLayerComponentPrototype prototype, Level level, Entity entity) {
        try {
            return new GroundLayerComponent();
        } catch (Exception e) {
            throw new ComponentCreateException(prototype, e);
        }
    }

    @Override
    public Class<GroundLayerComponentPrototype> getFactoryType() {
        return GroundLayerComponentPrototype.class;
    }
}
