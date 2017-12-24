package remove.tanks.game.level.engine.entity.component.layer;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;

/**
 * @author Mateusz Długosz
 */
public final class ObstacleLayerComponentFactory
        implements RegistrableComponentFactory<ObstacleLayerComponent, ObstacleLayerComponentPrototype>
{
    @Override
    public ObstacleLayerComponent createComponent(ObstacleLayerComponentPrototype prototype, Level level, Entity entity) {
        try {
            return new ObstacleLayerComponent();
        } catch (Exception e) {
            throw new ComponentCreateException(prototype, e);
        }
    }

    @Override
    public Class<ObstacleLayerComponentPrototype> getFactoryType() {
        return ObstacleLayerComponentPrototype.class;
    }
}
