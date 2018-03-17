package remove.tanks.game.level.utility.timeline;

import remove.tanks.game.level.event.Event;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class TimelineEntry {
    private final float time;
    private final List<Event> events;

    public TimelineEntry(float time, List<Event> events) {
        this.time = time;
        this.events = events;
    }

    public float getTime() {
        return time;
    }

    public List<Event> getEvents() {
        return events;
    }
}
