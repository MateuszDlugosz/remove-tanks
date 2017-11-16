package remove.tanks.game.level.engine.entity.component.actor;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * @author Mateusz Długosz
 */
public final class ActorComponent implements Component {
    public static final ComponentMapper<ActorComponent> MAPPER
            = ComponentMapper.getFor(ActorComponent.class);
}
