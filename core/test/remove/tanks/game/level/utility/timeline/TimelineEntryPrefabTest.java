package remove.tanks.game.level.utility.timeline;

import com.google.common.base.MoreObjects;
import org.junit.Test;
import remove.tanks.game.level.event.EventPrefab;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class TimelineEntryPrefabTest {
    @Test
    public void Should_ReturnFormattedStringRepresentation() {
        List<EventPrefab> eventPrefabs = new ArrayList<>();
        eventPrefabs.add(new TestEventPrefab("test-0"));
        eventPrefabs.add(new TestEventPrefab("test-1"));

        assertEquals("TimelineEntryPrefab{time=10.0, eventPrefabs=[TestEventPrefab{testString=test-0}, " +
                "TestEventPrefab{testString=test-1}]}", new TimelineEntryPrefab(10, eventPrefabs).toString());
    }

    private static final class TestEventPrefab extends EventPrefab {
        private final String testString;

        public TestEventPrefab(String testString) {
            this.testString = testString;
        }

        public String getTestString() {
            return testString;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("testString", testString)
                    .toString();
        }
    }
}