package remove.tanks.game.level.engine.entity.component.layer;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * @author Mateusz Długosz
 */
public final class BulletLayerComponent implements Component {
    public static final ComponentMapper<BulletLayerComponent> MAPPER
            = ComponentMapper.getFor(BulletLayerComponent.class);
}
