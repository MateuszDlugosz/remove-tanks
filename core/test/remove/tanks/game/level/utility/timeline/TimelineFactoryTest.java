package remove.tanks.game.level.utility.timeline;

import com.google.common.base.MoreObjects;
import com.google.common.eventbus.EventBus;
import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.level.event.Event;
import remove.tanks.game.level.event.EventFactory;
import remove.tanks.game.level.event.EventPrefab;
import remove.tanks.game.level.event.SubEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Mateusz Długosz
 */
public class TimelineFactoryTest {
    private TimelineFactory timelineFactory;
    private ResourceRegistry resourceRegistry;

    @Before
    public void initTestObjects() {
        timelineFactory = new TimelineFactory(
                new TimelineEntryFactory(
                        new EventFactory(
                                new SubEventFactory[] {
                                        new TestEvent0Factory()
                                }
                        )
                )
        );
        resourceRegistry = new ResourceRegistry();
    }

    @Test
    public void Should_CreateTimeline() {
        List<EventPrefab> eventPrefabs = new ArrayList<>();
        eventPrefabs.add(new TestEventPrefab0());
        eventPrefabs.add(new TestEventPrefab0());

        List<TimelineEntryPrefab> timelineEntryPrefabs = new ArrayList<>();
        timelineEntryPrefabs.add(new TimelineEntryPrefab(1f, eventPrefabs));

        TimelinePrefab prefab = new TimelinePrefab(timelineEntryPrefabs);
        Timeline timeline = timelineFactory.createTimeline(prefab, resourceRegistry);

        assertFalse(timeline.isEnded());

        timeline.update(10f, new EventBus());

        assertTrue(timeline.isEnded());
    }

    @Test(expected = TimelineCreateException.class)
    public void Should_ThrowException_When_CannotCreateTimeline() {
        List<EventPrefab> eventPrefabs = new ArrayList<>();
        eventPrefabs.add(new TestEventPrefab0());
        eventPrefabs.add(new TestEventPrefab1());

        List<TimelineEntryPrefab> timelineEntryPrefabs = new ArrayList<>();
        timelineEntryPrefabs.add(new TimelineEntryPrefab(1f, eventPrefabs));

        TimelinePrefab prefab = new TimelinePrefab(timelineEntryPrefabs);
        timelineFactory.createTimeline(prefab, resourceRegistry);
    }

    @Test
    public void Should_CreateTimelines() {
        List<EventPrefab> eventPrefabs0 = new ArrayList<>();
        eventPrefabs0.add(new TestEventPrefab0());
        eventPrefabs0.add(new TestEventPrefab0());

        List<EventPrefab> eventPrefabs1 = new ArrayList<>();
        eventPrefabs1.add(new TestEventPrefab0());

        List<TimelineEntryPrefab> timelineEntryPrefabs0 = new ArrayList<>();
        timelineEntryPrefabs0.add(new TimelineEntryPrefab(1f, eventPrefabs0));

        List<TimelineEntryPrefab> timelineEntryPrefabs1 = new ArrayList<>();
        timelineEntryPrefabs1.add(new TimelineEntryPrefab(1f, eventPrefabs1));

        List<TimelinePrefab> prefabs = new ArrayList<>();
        prefabs.add(new TimelinePrefab(timelineEntryPrefabs0));
        prefabs.add(new TimelinePrefab(timelineEntryPrefabs1));

        List<Timeline> timelines = timelineFactory.createTimelines(prefabs, resourceRegistry);

        assertEquals(2, timelines.size());
    }

    @Test(expected = TimelineCreateException.class)
    public void Should_ThrowException_When_CannotCreateTimelines() {
        List<EventPrefab> eventPrefabs0 = new ArrayList<>();
        eventPrefabs0.add(new TestEventPrefab0());
        eventPrefabs0.add(new TestEventPrefab0());

        List<EventPrefab> eventPrefabs1 = new ArrayList<>();
        eventPrefabs1.add(new TestEventPrefab1());

        List<TimelineEntryPrefab> timelineEntryPrefabs0 = new ArrayList<>();
        timelineEntryPrefabs0.add(new TimelineEntryPrefab(1f, eventPrefabs0));

        List<TimelineEntryPrefab> timelineEntryPrefabs1 = new ArrayList<>();
        timelineEntryPrefabs1.add(new TimelineEntryPrefab(1f, eventPrefabs1));

        List<TimelinePrefab> prefabs = new ArrayList<>();
        prefabs.add(new TimelinePrefab(timelineEntryPrefabs0));
        prefabs.add(new TimelinePrefab(timelineEntryPrefabs1));

        timelineFactory.createTimelines(prefabs, resourceRegistry);
    }

    private static final class TestEventPrefab0 extends EventPrefab {
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .toString();
        }
    }
    private static final class TestEventPrefab1 extends EventPrefab {
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .toString();
        }
    }

    private static final class TestEvent0 implements Event {}

    private static final class TestEvent0Factory implements SubEventFactory<TestEvent0, TestEventPrefab0> {
        @Override
        public TestEvent0 createEvent(TestEventPrefab0 prefab, ResourceRegistry registry) {
            return new TestEvent0();
        }

        @Override
        public Class<TestEventPrefab0> getFactoryType() {
            return TestEventPrefab0.class;
        }
    }
}