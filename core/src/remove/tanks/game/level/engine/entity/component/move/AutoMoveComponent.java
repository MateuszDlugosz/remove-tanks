package remove.tanks.game.level.engine.entity.component.move;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * @author Mateusz Długosz
 */
public final class AutoMoveComponent implements Component {
    private static final ComponentMapper<AutoMoveComponent> MAPPER
            = ComponentMapper.getFor(AutoMoveComponent.class);
}
