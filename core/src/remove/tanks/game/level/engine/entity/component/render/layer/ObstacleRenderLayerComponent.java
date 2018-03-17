package remove.tanks.game.level.engine.entity.component.render.layer;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * @author Mateusz Długosz
 */
public final class ObstacleRenderLayerComponent implements Component {
    public static final ComponentMapper<ObstacleRenderLayerComponent> MAPPER
            = ComponentMapper.getFor(ObstacleRenderLayerComponent.class);
}
