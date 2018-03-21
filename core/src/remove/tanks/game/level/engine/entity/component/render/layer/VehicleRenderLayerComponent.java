package remove.tanks.game.level.engine.entity.component.render.layer;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * @author Mateusz Długosz
 */
public final class VehicleRenderLayerComponent implements Component {
    public static final ComponentMapper<VehicleRenderLayerComponent> MAPPER
            = ComponentMapper.getFor(VehicleRenderLayerComponent.class);

    public static final VehicleRenderLayerComponent INSTANCE = new VehicleRenderLayerComponent();

    private VehicleRenderLayerComponent() {}
}
