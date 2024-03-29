package remove.tanks.game.level.engine.entity.component.render.layer;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * @author Mateusz Długosz
 */
public final class GroundRenderLayerComponent implements Component {
    public static final ComponentMapper<GroundRenderLayerComponent> MAPPER
            = ComponentMapper.getFor(GroundRenderLayerComponent.class);

    public static final GroundRenderLayerComponent INSTANCE = new GroundRenderLayerComponent();

    private GroundRenderLayerComponent() {}
}
