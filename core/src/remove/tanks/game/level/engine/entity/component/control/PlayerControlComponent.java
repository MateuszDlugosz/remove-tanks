package remove.tanks.game.level.engine.entity.component.control;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
import com.google.common.base.MoreObjects;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class PlayerControlComponent implements Component {
    public static final ComponentMapper<PlayerControlComponent> MAPPER
            = ComponentMapper.getFor(PlayerControlComponent.class);

    private final float shootDelay;
    private final Timer timer;

    public PlayerControlComponent(float shootDelay, Timer timer) {
        this.shootDelay = shootDelay;
        this.timer = timer;
    }

    public float getShootDelay() {
        return shootDelay;
    }

    public Timer getTimer() {
        return timer;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("shootDelay", shootDelay)
                .add("timer", timer)
                .toString();
    }
}
