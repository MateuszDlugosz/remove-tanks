package remove.tanks.game.level.engine.entity.component.destroy;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * @author Mateusz Długosz
 */
public final class DestroyOnContactComponent implements Component {
    public static final ComponentMapper<DestroyOnContactComponent> MAPPER
            = ComponentMapper.getFor(DestroyOnContactComponent.class);
}
