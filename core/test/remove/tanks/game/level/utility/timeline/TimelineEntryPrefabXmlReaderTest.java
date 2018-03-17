package remove.tanks.game.level.utility.timeline;

import com.badlogic.gdx.utils.XmlReader;
import com.google.common.base.MoreObjects;
import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.level.event.EventPrefab;
import remove.tanks.game.level.event.EventPrefabXmlReader;
import remove.tanks.game.level.event.EventType;
import remove.tanks.game.level.event.SubEventPrefabXmlReader;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Mateusz Długosz
 */
public class TimelineEntryPrefabXmlReaderTest {
    private static final String TIMELINE_ENTRY_PREFAB_CORRECT_ELEMENT =
            "<timelineEntry>" +
                    "<time>1</time>" +
                    "<events>" +
                    "   <event type=\"ActivateSystemEvent\" />" +
                    "</events>" +
            "</timelineEntry>";

    private static final String TIMELINE_ENTRY_PREFAB_INCORRECT_ELEMENT =
            "<timelineEntry></timelineEntry>";

    private static final String TIMELINE_ENTRY_PREFABS_CORRECT_ELEMENT =
            "<timelineEntries>" +
                    "<timelineEntry>" +
                    "    <time>1</time>" +
                    "    <events>" +
                    "       <event type=\"ActivateSystemEvent\" />" +
                    "    </events>" +
                    "</timelineEntry>" +
                    "<timelineEntry>" +
                    "    <time>2</time>" +
                    "    <events>" +
                    "       <event type=\"ActivateSystemEvent\" />" +
                    "       <event type=\"ActivateSystemEvent\" />" +
                    "    </events>" +
                    "</timelineEntry>" +
            "</timelineEntries>";

    private static final String TIMELINE_ENTRY_PREFABS_INCORRECT_ELEMENT =
            "<timelineEntries>" +
                    "<timelineEntry>" +
                    "    <time>1</time>" +
                    "    <events>" +
                    "       <event type=\"ActivateSystemEvent\" />" +
                    "    </events>" +
                    "</timelineEntry>" +
                    "<timelineEntry>" +
                    "</timelineEntry>" +
            "</timelineEntries>";

    private XmlReader xmlReader;
    private TimelineEntryPrefabXmlReader timelineEntryPrefabXmlReader;

    @Before
    public void initTestObjects() {
        EventPrefabXmlReader eventPrefabXmlReader = new EventPrefabXmlReader(
                new SubEventPrefabXmlReader[] {
                        new TestEventPrefabXmlReader()
                }
        );
        xmlReader = new XmlReader();
        timelineEntryPrefabXmlReader = new TimelineEntryPrefabXmlReader(eventPrefabXmlReader);
    }

    @Test
    public void Should_ReturnTimelineEntryPrefab_When_ProvidedElementIsCorrect() {
        TimelineEntryPrefab prefab = timelineEntryPrefabXmlReader
                .readTimelineEntryPrefab(xmlReader.parse(TIMELINE_ENTRY_PREFAB_CORRECT_ELEMENT));

        assertEquals(1f, prefab.getTime(), 0.001f);
        assertEquals(1, prefab.getEventPrefabs().size());
        assertTrue(TestEventPrefab.class.equals(prefab.getEventPrefabs().get(0).getClass()));
    }

    @Test(expected = TimelineEntryXmlReadException.class)
    public void Should_ThrowException_When_ProvidedElementIsIncorrect() {
        timelineEntryPrefabXmlReader.readTimelineEntryPrefab(xmlReader.parse(TIMELINE_ENTRY_PREFAB_INCORRECT_ELEMENT));
    }

    @Test
    public void Should_ReturnTimelineEntryPrefabs_When_ProvidedElementIsCorrect() {
        List<TimelineEntryPrefab> prefabs = timelineEntryPrefabXmlReader
                .readTimelineEntryPrefabs(xmlReader.parse(TIMELINE_ENTRY_PREFABS_CORRECT_ELEMENT));

        assertEquals(2, prefabs.size());
        assertEquals(1f, prefabs.get(0).getTime(), 0.001f);
        assertEquals(2f, prefabs.get(1).getTime(), 0.001f);
        assertEquals(1, prefabs.get(0).getEventPrefabs().size());
        assertEquals(2, prefabs.get(1).getEventPrefabs().size());
    }

    @Test(expected = TimelineEntryXmlReadException.class)
    public void Should_ThrowException_When_AtLeastOneTimelineEntryIsIncorrectlyFormatted() {
        timelineEntryPrefabXmlReader
                .readTimelineEntryPrefabs(xmlReader.parse(TIMELINE_ENTRY_PREFABS_INCORRECT_ELEMENT));
    }

    private static final class TestEventPrefab extends EventPrefab {
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .toString();
        }
    }

    private static final class TestEventPrefabXmlReader implements SubEventPrefabXmlReader<TestEventPrefab> {
        @Override
        public TestEventPrefab readEventPrefab(XmlReader.Element element) {
            return new TestEventPrefab();
        }

        @Override
        public EventType getReaderType() {
            return EventType.ActivateSystemEvent;
        }
    }
}