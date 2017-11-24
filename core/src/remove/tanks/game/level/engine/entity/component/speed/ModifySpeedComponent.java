package remove.tanks.game.level.engine.entity.component.speed;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * @author Mateusz Długosz
 */
public final class ModifySpeedComponent implements Component {
    public static final ComponentMapper<ModifySpeedComponent> MAPPER
            = ComponentMapper.getFor(ModifySpeedComponent.class);

    private final float value;

    public ModifySpeedComponent(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }
}
