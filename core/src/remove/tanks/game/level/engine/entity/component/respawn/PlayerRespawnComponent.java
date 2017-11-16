package remove.tanks.game.level.engine.entity.component.respawn;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * @author Mateusz Długosz
 */
public final class PlayerRespawnComponent implements Component {
    public static final ComponentMapper<PlayerRespawnComponent> MAPPER
            = ComponentMapper.getFor(PlayerRespawnComponent.class);
}
