package remove.tanks.game.level.utility.timeline;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.junit.Test;
import remove.tanks.game.level.event.Event;
import remove.tanks.game.utility.time.Timer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Mateusz Długosz
 */
public class TimelineTest {
    @Test
    public void Should_ListenerContainsAllEvents() {
        List<Event> events = new ArrayList<>();
        events.add(new TestEvent(1));
        events.add(new TestEvent(2));

        List<TimelineEntry> timelineEntries = new ArrayList<>();
        timelineEntries.add(new TimelineEntry(1f, events));

        TestEventListener listener = new TestEventListener();
        EventBus eventBus = new EventBus();
        eventBus.register(listener);

        Timeline timeline = new Timeline(timelineEntries, new Timer(10f));
        timeline.update(5f, eventBus);

        assertEquals(2, listener.getEvents().size());
        assertEquals(1, listener.getEvents().get(0).getControlNumber());
        assertEquals(2, listener.getEvents().get(1).getControlNumber());
    }

    @Test
    public void Should_ReturnTimelineEndedTrue_When_NoEntriesLeftInTimeline() {
        assertTrue(new Timeline(new ArrayList<>(), new Timer(-1)).isEnded());
    }

    private static final class TestEvent implements Event {
        private final int controlNumber;

        public int getControlNumber() {
            return controlNumber;
        }

        public TestEvent(int controlNumber) {
            this.controlNumber = controlNumber;
        }
    }

    private static final class TestEventListener {
        private final List<TestEvent> events = new ArrayList<>();

        public List<TestEvent> getEvents() {
            return events;
        }

        @Subscribe
        public void handleTestEvent(TestEvent event) {
            events.add(event);
        }
    }
}