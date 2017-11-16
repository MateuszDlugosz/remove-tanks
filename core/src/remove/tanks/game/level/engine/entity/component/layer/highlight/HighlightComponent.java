package remove.tanks.game.level.engine.entity.component.layer.highlight;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class HighlightComponent implements Component {
    public static final ComponentMapper<HighlightComponent> MAPPER
            = ComponentMapper.getFor(HighlightComponent.class);

    private final Timer timer;

    public HighlightComponent(Timer timer) {
        this.timer = timer;
    }

    public Timer getTimer() {
        return timer;
    }
}
