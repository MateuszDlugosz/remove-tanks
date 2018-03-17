package remove.tanks.game.level.engine.entity.component.lifecycle;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * @author Mateusz Długosz
 */
public final class DestroyOnContactLostComponent implements Component {
    public static final ComponentMapper<DestroyOnContactLostComponent> MAPPER
            = ComponentMapper.getFor(DestroyOnContactLostComponent.class);
}
