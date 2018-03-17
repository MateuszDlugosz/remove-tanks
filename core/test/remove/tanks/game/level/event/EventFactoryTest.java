package remove.tanks.game.level.event;

import com.google.common.base.MoreObjects;
import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.level.resource.ResourceRegistry;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Mateusz Długosz
 */
public class EventFactoryTest {
    private EventFactory eventFactory;
    private ResourceRegistry resourceRegistry;

    @Before
    public void initTestObjects() {
        eventFactory = new EventFactory(
                new SubEventFactory[] {
                        new TestEvent0Factory()
                }
        );
        resourceRegistry = new ResourceRegistry();
    }

    @Test
    public void Should_CreateEvent() {
        TestEventPrefab0 prefab0 = new TestEventPrefab0();
        assertTrue(TestEvent0.class.equals(eventFactory.createEvent(prefab0, resourceRegistry).getClass()));
    }

    @Test(expected = EventCreateException.class)
    public void Should_ThrowException_When_SubEventPrefabFactoryIsNoRegistered() {
        eventFactory.createEvent(new TestEventPrefab1(), resourceRegistry);
    }

    @Test
    public void Should_CreateEvents() {
        List<EventPrefab> prefabs = new ArrayList<>();
        prefabs.add(new TestEventPrefab0());
        prefabs.add(new TestEventPrefab0());

        assertEquals(2, eventFactory.createEvents(prefabs, resourceRegistry).size());
    }

    @Test(expected = EventCreateException.class)
    public void Should_ThrowException_When_AtLeastOneSubEventPrefabFactoryIsNoRegistered() {
        List<EventPrefab> prefabs = new ArrayList<>();
        prefabs.add(new TestEventPrefab0());
        prefabs.add(new TestEventPrefab1());
        eventFactory.createEvents(prefabs, resourceRegistry);
    }

    private static final class TestEvent0 implements Event {}

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