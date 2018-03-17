package remove.tanks.game.level.engine.entity.component.speed;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * @author Mateusz Długosz
 */
public final class SpeedModifierComponent implements Component {
    public static final ComponentMapper<SpeedModifierComponent> MAPPER
            = ComponentMapper.getFor(SpeedModifierComponent.class);
    public static final float DEFAULT_SPEED_MODIFIER = 1f;

    private final float speedModifier;

    public SpeedModifierComponent(float speedModifier) {
        this.speedModifier = speedModifier;
    }

    public float getSpeedModifier() {
        return speedModifier;
    }
}
