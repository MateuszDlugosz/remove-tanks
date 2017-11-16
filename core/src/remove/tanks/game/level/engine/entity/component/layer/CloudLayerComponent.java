package remove.tanks.game.level.engine.entity.component.layer;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * @author Mateusz Długosz
 */
public final class CloudLayerComponent implements Component {
    public static final ComponentMapper<CloudLayerComponent> MAPPER
            = ComponentMapper.getFor(CloudLayerComponent.class);
}
