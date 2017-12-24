package remove.tanks.game.level.engine.system.time;

import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.engine.system.time.timeline.Timeline;
import remove.tanks.game.level.engine.system.time.timeline.TimelineFactory;
import remove.tanks.game.level.engine.system.time.timeline.TimelinePrototype;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class TimelineSystemFactory
        implements RegistrableEntitySystemFactory<TimelineSystem, TimelineSystemPrototype>
{
    private final TimelineFactory timelineFactory;

    public TimelineSystemFactory(TimelineFactory timelineFactory) {
        this.timelineFactory = timelineFactory;
    }

    @Override
    public TimelineSystem createEntitySystem(TimelineSystemPrototype prototype, ResourceRegistry resourceRegistry) {
        try {
            return new TimelineSystem(
                    prototype.getPriority(),
                    createTimeline(prototype.getTimelinePrototype()),
                    createTimer(-1),
                    resourceRegistry.getResource(LevelResource.EventBus.toString(), EventBus.class)
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prototype, e);
        }
    }

    private Timer createTimer(float time) {
        return new Timer(time);
    }

    private Timeline createTimeline(TimelinePrototype prototype) {
        return timelineFactory.createTimeline(prototype);
    }

    @Override
    public Class<TimelineSystemPrototype> getFactoryType() {
        return null;
    }
}
