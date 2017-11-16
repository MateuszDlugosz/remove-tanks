package remove.tanks.game.level.engine.entity.component.shoot;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * @author Mateusz Długosz
 */
public final class AutoShootComponent implements Component {
    public static final ComponentMapper<AutoShootComponent> MAPPER
            = ComponentMapper.getFor(AutoShootComponent.class);
}
