package remove.tanks.game.level.utility.timeline;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.utility.time.Timer;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class Timeline {
    private final List<TimelineEntry> timelineEntries;
    private final Timer timer;

    Timeline(List<TimelineEntry> timelineEntries, Timer timer) {
        this.timelineEntries = timelineEntries;
        this.timer = timer;
    }

    public void update(float delta, EventBus eventBus) {
        timer.update(delta);
        if (timelineEntries.size() > 0) {
            if (timelineEntries.get(0).getTime() <= timer.getTime()) {
                timelineEntries.get(0).getEvents().forEach(eventBus::post);
                timelineEntries.remove(0);
            }
        }
    }

    public boolean isEnded() {
        return timelineEntries.size() == 0;
    }
}
