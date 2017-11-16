package remove.tanks.game.level.engine.entity.component.speed;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * @author Mateusz Długosz
 */
public final class SpeedComponent implements Component {
    public static final ComponentMapper<SpeedComponent> MAPPER
            = ComponentMapper.getFor(SpeedComponent.class);

    private final float speed;

    public SpeedComponent(float speed) {
        this.speed = speed;
    }

    public float getSpeed() {
        return speed;
    }
}
