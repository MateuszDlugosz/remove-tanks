package remove.tanks.game.level.engine.entity.component.faction;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * @author Mateusz Długosz
 */
public final class PlayerComponent implements Component {
    public static final ComponentMapper<PlayerComponent> MAPPER
            = ComponentMapper.getFor(PlayerComponent.class);

    public static final PlayerComponent INSTANCE = new PlayerComponent();

    private PlayerComponent() {}
}
