package remove.tanks.game.level.engine.entity.component.render.layer;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * @author Mateusz Długosz
 */
public final class BombRenderLayerComponent implements Component {
    public static final ComponentMapper<BombRenderLayerComponent> MAPPER
            = ComponentMapper.getFor(BombRenderLayerComponent.class);
}
