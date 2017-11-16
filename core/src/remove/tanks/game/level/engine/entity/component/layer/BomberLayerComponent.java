package remove.tanks.game.level.engine.entity.component.layer;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * @author Mateusz Długosz
 */
public final class BomberLayerComponent implements Component {
    public static final ComponentMapper<BomberLayerComponent> MAPPER
            = ComponentMapper.getFor(BomberLayerComponent.class);
}
