package remove.tanks.game.level.engine.entity.component.layer;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * @author Mateusz Długosz
 */
public final class VehicleLayerComponent implements Component {
    public static final ComponentMapper<VehicleLayerComponent> MAPPER
            = ComponentMapper.getFor(VehicleLayerComponent.class);
}
