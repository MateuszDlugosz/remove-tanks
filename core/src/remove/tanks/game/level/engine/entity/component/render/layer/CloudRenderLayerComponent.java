package remove.tanks.game.level.engine.entity.component.render.layer;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * @author Mateusz Długosz
 */
public final class CloudRenderLayerComponent implements Component {
    public static final ComponentMapper<CloudRenderLayerComponent> MAPPER
            = ComponentMapper.getFor(CloudRenderLayerComponent.class);
}
