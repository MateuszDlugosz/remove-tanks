package remove.tanks.game.level.utility.timeline;

import com.google.common.base.MoreObjects;
import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.level.event.Event;
import remove.tanks.game.level.event.EventFactory;
import remove.tanks.game.level.event.EventPrefab;
import remove.tanks.game.level.event.SubEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Mateusz Długosz
 */
public class TimelineEntryFactoryTest {
    private TimelineEntryFactory timelineEntryFactory;
    private ResourceRegistry resourceRegistry;

    @Before
    public void initTestObjects() {
        timelineEntryFactory = new TimelineEntryFactory(
                new EventFactory(
                        new SubEventFactory[] {
                                new TestEventFactory()
                        }
                )
        );
        resourceRegistry = new ResourceRegistry();
    }

    @Test
    public void Should_ReturnTimelineEntry() {
        List<EventPrefab> eventPrefabs = new ArrayList<>();
        eventPrefabs.add(new TestEventPrefab());
        eventPrefabs.add(new TestEventPrefab());

        TimelineEntryPrefab prefab = new TimelineEntryPrefab(1f, eventPrefabs);
        TimelineEntry entry = timelineEntryFactory.createTimelineEntry(prefab, resourceRegistry);

        assertEquals(1f, entry.getTime(), 0.001f);
        assertEquals(2, entry.getEvents().size());
        assertTrue(TestEvent.class.equals(entry.getEvents().get(0).getClass()));
        assertTrue(TestEvent.class.equals(entry.getEvents().get(1).getClass()));
    }

    @Test(expected = TimelineEntryCreateException.class)
    public void Should_ThrowException_When_CannotCreateFromPrefab() {
        List<EventPrefab> eventPrefabs = new ArrayList<>();
        eventPrefabs.add(new TestEventPrefab());
        eventPrefabs.add(new TestEventPrefab2());

        TimelineEntryPrefab prefab = new TimelineEntryPrefab(1f, eventPrefabs);

        timelineEntryFactory.createTimelineEntry(prefab, resourceRegistry);
    }

    @Test
    public void Should_ReturnTimelineEntries() {
        List<EventPrefab> eventPrefabs0 = new ArrayList<>();
        eventPrefabs0.add(new TestEventPrefab());
        eventPrefabs0.add(new TestEventPrefab());

        List<EventPrefab> eventPrefabs1 = new ArrayList<>();
        eventPrefabs1.add(new TestEventPrefab());

        List<TimelineEntryPrefab> prefabs = new ArrayList<>();
        prefabs.add(new TimelineEntryPrefab(1f, eventPrefabs0));
        prefabs.add(new TimelineEntryPrefab(2f, eventPrefabs1));

        List<TimelineEntry> entries = timelineEntryFactory.createTimelineEntries(prefabs, resourceRegistry);

        assertEquals(2, entries.size());
        assertEquals(1f, entries.get(0).getTime(), 0.001f);
        assertEquals(2f, entries.get(1).getTime(), 0.001f);
        assertEquals(2, entries.get(0).getEvents().size());
        assertEquals(1, entries.get(1).getEvents().size());
    }

    @Test(expected = TimelineEntryCreateException.class)
    public void Should_ThrowException_When_CannotCreateFromPrefabs() {
        List<EventPrefab> eventPrefabs0 = new ArrayList<>();
        eventPrefabs0.add(new TestEventPrefab());
        eventPrefabs0.add(new TestEventPrefab());

        List<EventPrefab> eventPrefabs1 = new ArrayList<>();
        eventPrefabs1.add(new TestEventPrefab2());

        List<TimelineEntryPrefab> prefabs = new ArrayList<>();
        prefabs.add(new TimelineEntryPrefab(1f, eventPrefabs0));
        prefabs.add(new TimelineEntryPrefab(2f, eventPrefabs1));

        timelineEntryFactory.createTimelineEntries(prefabs, resourceRegistry);
    }

    private static final class TestEventPrefab extends EventPrefab {
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .toString();
        }
    }
    private static final class TestEventPrefab2 extends EventPrefab {
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .toString();
        }
    }
    private static final class TestEvent implements Event {}

    private static final class TestEventFactory implements SubEventFactory<TestEvent, TestEventPrefab> {
        @Override
        public TestEvent createEvent(TestEventPrefab prefab, ResourceRegistry registry) {
            return new TestEvent();
        }

        @Override
        public Class<TestEventPrefab> getFactoryType() {
            return TestEventPrefab.class;
        }
    }
}