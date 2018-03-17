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

/**
 * @author Mateusz Długosz
 */
public class TimelinePrefabXmlReaderTest {
    private static final String TIMELINE_PREFAB_CORRECT_ELEMENT =
            "<timeline>" +
                    "<timelineEntries>" +
                    "   <timelineEntry>" +
                    "       <time>2</time>" +
                    "       <events>" +
                    "           <event type=\"ActivateSystemEvent\" />" +
                    "       </events>" +
                    "   </timelineEntry>" +
                    "</timelineEntries>" +
            "</timeline>";

    private static final String TIMELINE_PREFAB_INCORRECT_ELEMENT =
            "<timeline></timeline>";

    private static final String TIMELINES_PREFAB_CORRECT_ELEMENT =
            "<timelines>" +
                    "<timeline>" +
                        "<timelineEntries>" +
                        "   <timelineEntry>" +
                        "       <time>2</time>" +
                        "       <events>" +
                        "           <event type=\"ActivateSystemEvent\" />" +
                        "       </events>" +
                        "   </timelineEntry>" +
                        "</timelineEntries>" +
                    "</timeline>" +
                    "<timeline>" +
                    "<timelineEntries>" +
                    "   <timelineEntry>" +
                    "       <time>1</time>" +
                    "       <events>" +
                    "           <event type=\"ActivateSystemEvent\" />" +
                    "       </events>" +
                    "   </timelineEntry>" +
                    "</timelineEntries>" +
                    "</timeline>" +
            "</timelines>";

    private static final String TIMELINES_PREFAB_INCORRECT_ELEMENT =
            "<timelines>" +
                    "<timeline></timeline>" +
                    "<timeline>" +
                    "<timelineEntries>" +
                    "   <timelineEntry>" +
                    "       <time>2</time>" +
                    "       <events>" +
                    "           <event type=\"ActivateSystemEvent\" />" +
                    "       </events>" +
                    "   </timelineEntry>" +
                    "</timelineEntries>" +
                    "</timeline>" +
            "</timelines>";

    private XmlReader xmlReader;
    private TimelinePrefabXmlReader timelinePrefabXmlReader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        timelinePrefabXmlReader = new TimelinePrefabXmlReader(
                new TimelineEntryPrefabXmlReader(
                        new EventPrefabXmlReader(
                                new SubEventPrefabXmlReader[] {
                                        new TestEventPrefab0XmlReader()
                                }
                        )
                )
        );
    }

    @Test
    public void Should_ReturnTimelinePrefab() {
        TimelinePrefab prefab = timelinePrefabXmlReader
                .readTimelinePrefab(xmlReader.parse(TIMELINE_PREFAB_CORRECT_ELEMENT));

        assertEquals(1, prefab.getTimelineEntryPrefabs().size());
        assertEquals(2f, prefab.getTimelineEntryPrefabs().get(0).getTime(), 0.001f);
        assertEquals(1, prefab.getTimelineEntryPrefabs().get(0).getEventPrefabs().size());
    }

    @Test(expected = TimelinePrefabXmlReadException.class)
    public void Should_ThrowException_When_ElementIsIncorrectlyFormatted() {
        timelinePrefabXmlReader.readTimelinePrefab(xmlReader.parse(TIMELINE_PREFAB_INCORRECT_ELEMENT));
    }

    @Test
    public void Should_ReturnTimelinePrefabs() {
        List<TimelinePrefab> prefabs = timelinePrefabXmlReader
                .readTimelinePrefabs(xmlReader.parse(TIMELINES_PREFAB_CORRECT_ELEMENT));

        assertEquals(2, prefabs.size());
        assertEquals(2f, prefabs.get(0).getTimelineEntryPrefabs().get(0).getTime(), 0.001f);
        assertEquals(1f, prefabs.get(1).getTimelineEntryPrefabs().get(0).getTime(), 0.001f);
    }

    @Test(expected = TimelinePrefabXmlReadException.class)
    public void Should_ThrowException_When_AtLeastOneElementsIsIncorrectlyFormatted() {
        timelinePrefabXmlReader.readTimelinePrefabs(xmlReader.parse(TIMELINES_PREFAB_INCORRECT_ELEMENT));
    }

    private static final class TestEventPrefab0 extends EventPrefab {
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .toString();
        }
    }

    private static final class TestEventPrefab0XmlReader implements SubEventPrefabXmlReader<TestEventPrefab0> {
        @Override
        public TestEventPrefab0 readEventPrefab(XmlReader.Element element) {
            return new TestEventPrefab0();
        }

        @Override
        public EventType getReaderType() {
            return EventType.ActivateSystemEvent;
        }
    }
}