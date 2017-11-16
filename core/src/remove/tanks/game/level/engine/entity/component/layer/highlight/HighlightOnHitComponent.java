package remove.tanks.game.level.engine.entity.component.layer.highlight;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * @author Mateusz Długosz
 */
public final class HighlightOnHitComponent implements Component {
    public static final ComponentMapper<HighlightOnHitComponent> MAPPER
            = ComponentMapper.getFor(HighlightOnHitComponent.class);
}
