package remove.tanks.game.level.engine.system.time;

import com.badlogic.ashley.core.EntitySystem;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.utility.timeline.Timeline;

/**
 * @author Mateusz Długosz
 */
public final class TimelineSystem extends EntitySystem {
    private final Timeline timeline;
    private final EventBus eventBus;

    public TimelineSystem(int priority, Timeline timeline, EventBus eventBus) {
        super(priority);
        this.timeline = timeline;
        this.eventBus = eventBus;
    }

    @Override
    public void update(float deltaTime) {
        if (!timeline.isEnded()) {
            timeline.update(deltaTime, eventBus);
        } else {
            getEngine().removeSystem(this);
        }
    }
}
