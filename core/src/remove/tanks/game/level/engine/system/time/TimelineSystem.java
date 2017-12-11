package remove.tanks.game.level.engine.system.time;

import com.badlogic.ashley.core.EntitySystem;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.engine.system.time.timeline.Timeline;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class TimelineSystem extends EntitySystem {
    private final Timeline timeline;
    private final Timer timer;
    private final EventBus eventBus;

    public TimelineSystem(int priority, Timeline timeline, Timer timer, EventBus eventBus) {
        super(priority);
        this.timeline = timeline;
        this.timer = timer;
        this.eventBus = eventBus;
    }

    @Override
    public void update(float deltaTime) {
        if (timeline.getTimelineEntries().size() > 0) {
            timer.update(deltaTime);
            if (timeline.getTimelineEntries().get(0).getTime() >= timer.getTime()) {
                timeline.getTimelineEntries().get(0).getEvents().forEach(eventBus::post);
                timeline.getTimelineEntries().remove(0);
            }
        } else {
            getEngine().removeSystem(this);
        }
    }
}
