package remove.tanks.game.level.engine.entity.component.render.layer;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * @author Mateusz Długosz
 */
public final class AirplaneRenderLayerComponent implements Component {
    public static final ComponentMapper<AirplaneRenderLayerComponent> MAPPER
            = ComponentMapper.getFor(AirplaneRenderLayerComponent.class);

    public static final AirplaneRenderLayerComponent INSTANCE = new AirplaneRenderLayerComponent();

    private AirplaneRenderLayerComponent() {}
}
