package remove.tanks.game.level.utility.timeline;

import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.utility.time.Timer;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class TimelineFactory {
    private final TimelineEntryFactory timelineEntryFactory;

    public TimelineFactory(TimelineEntryFactory timelineEntryFactory) {
        this.timelineEntryFactory = timelineEntryFactory;
    }

    public List<Timeline> createTimelines(List<TimelinePrefab> prefabs, ResourceRegistry registry) {
        return prefabs.stream()
                .map(p -> createTimeline(p, registry))
                .collect(Collectors.toList());
    }

    public Timeline createTimeline(TimelinePrefab prefab, ResourceRegistry registry) {
        try {
            return new Timeline(
                    createTimelineEntries(prefab.getTimelineEntryPrefabs(), registry),
                    createTimer()
            );
        } catch (Exception e) {
            throw new TimelineCreateException(prefab, e);
        }
    }

    private List<TimelineEntry> createTimelineEntries(List<TimelineEntryPrefab> prefabs, ResourceRegistry registry) {
        return timelineEntryFactory.createTimelineEntries(prefabs, registry).stream()
                .sorted(Comparator.comparing(TimelineEntry::getTime))
                .collect(Collectors.toList());
    }

    private Timer createTimer() {
        return new Timer(-1f);
    }
}
