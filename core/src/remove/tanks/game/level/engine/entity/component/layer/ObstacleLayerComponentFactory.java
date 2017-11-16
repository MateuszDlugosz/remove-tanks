package remove.tanks.game.level.engine.entity.component.layer;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentFactory;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class ObstacleLayerComponentFactory
        implements RegistrableComponentFactory<ObstacleLayerComponent, ObstacleLayerComponentPrototype>
{
    @Override
    public ObstacleLayerComponent createComponent(ObstacleLayerComponentPrototype prototype, Level level, Entity entity) {
        return new ObstacleLayerComponent();
    }

    @Override
    public Class<ObstacleLayerComponentPrototype> getFactoryType() {
        return ObstacleLayerComponentPrototype.class;
    }
}
