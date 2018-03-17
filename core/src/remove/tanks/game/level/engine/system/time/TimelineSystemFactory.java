package remove.tanks.game.level.engine.system.time;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.SubEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.level.utility.timeline.Timeline;
import remove.tanks.game.level.utility.timeline.TimelineFactory;
import remove.tanks.game.level.utility.timeline.TimelinePrefab;

/**
 * @author Mateusz Długosz
 */
public final class TimelineSystemFactory implements SubEntitySystemFactory<TimelineSystem, TimelineSystemPrefab> {
    private final TimelineFactory timelineFactory;

    public TimelineSystemFactory(TimelineFactory timelineFactory) {
        this.timelineFactory = timelineFactory;
    }

    @Override
    public TimelineSystem createEntitySystem(TimelineSystemPrefab prefab, ResourceRegistry registry) {
        try {
            return new TimelineSystem(
                    prefab.getPriority(),
                    createTimeline(prefab.getTimelinePrefab(), registry),
                    registry.getResource(ResourceType.EventBusResource, EventBus.class)
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prefab, e);
        }
    }

    private Timeline createTimeline(TimelinePrefab prefab, ResourceRegistry registry) {
        return timelineFactory.createTimeline(prefab, registry);
    }

    @Override
    public Class<TimelineSystemPrefab> getFactoryType() {
        return TimelineSystemPrefab.class;
    }
}
