package remove.tanks.game.level.engine.entity.component.speed;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * @author Mateusz Długosz
 */
public final class SpeedModifierComponent implements Component {
    public static final ComponentMapper<SpeedModifierComponent> MAPPER
            = ComponentMapper.getFor(SpeedModifierComponent.class);

    private final float value;

    public SpeedModifierComponent(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }
}
