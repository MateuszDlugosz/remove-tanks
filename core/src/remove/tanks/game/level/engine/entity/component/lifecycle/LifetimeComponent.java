package remove.tanks.game.level.engine.entity.component.lifecycle;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class LifetimeComponent implements Component {
    public static final ComponentMapper<LifetimeComponent> MAPPER
            = ComponentMapper.getFor(LifetimeComponent.class);

    private final Timer timer;

    public LifetimeComponent(Timer timer) {
        this.timer = timer;
    }

    public Timer getTimer() {
        return timer;
    }
}
