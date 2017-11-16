package remove.tanks.game.level.engine.entity.component.destroy;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * @author Mateusz Długosz
 */
public final class DestroyComponent implements Component {
    public static final ComponentMapper<DestroyComponent> MAPPER
            = ComponentMapper.getFor(DestroyComponent.class);
}
