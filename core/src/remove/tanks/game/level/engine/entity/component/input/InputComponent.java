package remove.tanks.game.level.engine.entity.component.input;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class InputComponent implements Component {
    public static final ComponentMapper<InputComponent> MAPPER
            = ComponentMapper.getFor(InputComponent.class);

    private final float shootDelay;
    private final Timer timer;

    public InputComponent(float shootDelay, Timer timer) {
        this.shootDelay = shootDelay;
        this.timer = timer;
    }

    public float getShootDelay() {
        return shootDelay;
    }

    public Timer getTimer() {
        return timer;
    }
}
