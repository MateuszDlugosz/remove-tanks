package remove.tanks.game.level.engine.entity.component.combat;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
import remove.tanks.game.graphics.effect.Effect;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class HitComponent implements Component {
    public static final ComponentMapper<HitComponent> MAPPER
            = ComponentMapper.getFor(HitComponent.class);

    private final Effect effect;
    private final Timer timer;

    public HitComponent(Effect effect, Timer timer) {
        this.effect = effect;
        this.timer = timer;
    }

    public Effect getEffect() {
        return effect;
    }

    public Timer getTimer() {
        return timer;
    }
}
