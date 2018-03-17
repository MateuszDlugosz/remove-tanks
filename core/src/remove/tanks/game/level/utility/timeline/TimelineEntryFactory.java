package remove.tanks.game.level.utility.timeline;

import remove.tanks.game.level.event.Event;
import remove.tanks.game.level.event.EventFactory;
import remove.tanks.game.level.event.EventPrefab;
import remove.tanks.game.level.resource.ResourceRegistry;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class TimelineEntryFactory {
    private final EventFactory eventFactory;

    public TimelineEntryFactory(EventFactory eventFactory) {
        this.eventFactory = eventFactory;
    }

    public List<TimelineEntry> createTimelineEntries(List<TimelineEntryPrefab> prefabs, ResourceRegistry registry) {
        return prefabs.stream()
                .map(p -> createTimelineEntry(p, registry))
                .collect(Collectors.toList());
    }

    public TimelineEntry createTimelineEntry(TimelineEntryPrefab prefab, ResourceRegistry registry) {
        try {
            return new TimelineEntry(
                    prefab.getTime(),
                    createEvents(prefab.getEventPrefabs(), registry)
            );
        } catch (Exception e) {
            throw new TimelineEntryCreateException(prefab, e);
        }
    }

    private List<Event> createEvents(List<EventPrefab> prefabs, ResourceRegistry registry) {
        return eventFactory.createEvents(prefabs, registry);
    }
}
