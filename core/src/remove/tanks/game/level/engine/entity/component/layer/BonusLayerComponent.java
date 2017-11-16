package remove.tanks.game.level.engine.entity.component.layer;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * @author Mateusz Długosz
 */
public final class BonusLayerComponent implements Component {
    public static final ComponentMapper<BonusLayerComponent> MAPPER
            = ComponentMapper.getFor(BonusLayerComponent.class);
}
