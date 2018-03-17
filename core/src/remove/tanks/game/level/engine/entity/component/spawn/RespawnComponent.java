package remove.tanks.game.level.engine.entity.component.spawn;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * @author Mateusz Długosz
 */
public final class RespawnComponent implements Component {
    private static final ComponentMapper<RespawnComponent> MAPPER
            = ComponentMapper.getFor(RespawnComponent.class);
}
