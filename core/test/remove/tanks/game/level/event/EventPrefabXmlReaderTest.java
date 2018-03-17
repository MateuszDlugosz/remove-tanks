package remove.tanks.game.level.event;

import com.badlogic.gdx.utils.XmlReader;
import com.google.common.base.MoreObjects;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Mateusz Długosz
 */
public class EventPrefabXmlReaderTest {
    private static final String EVENT_PREFAB_CORRECT_ELEMENT =
            "<event type=\"ActivateSystemEvent\" />";

    private static final String EVENT_PREFAB_INCORRECT_ELEMENT =
            "<event />";

    private static final String EVENT_PREFAB_UNKNOWN_TYPE_ELEMENT =
            "<event type=\"UnknownEventType\" />";

    private static final String EVENTS_PREFAB_CORRECT_ELEMENT =
            "<events>" +
                    "<event type=\"ActivateSystemEvent\" />" +
                    "<event type=\"ActivateSystemEvent\" />" +
            "</events>";

    private static final String EVENTS_PREFAB_INCORRECT_ELEMENT =
            "<events>" +
                    "<event type=\"ActivateSystemEvent\" />" +
                    "<event />" +
            "</events>";

    private static final String EVENTS_PREFAB_UNKNOWN_TYPE_ELEMENT =
            "<events>" +
                    "<event type=\"ActivateSystemEvent\" />" +
                    "<event type=\"UnknownEventType\" />" +
            "</events>";

    private XmlReader xmlReader;
    private EventPrefabXmlReader eventPrefabXmlReader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        eventPrefabXmlReader = new EventPrefabXmlReader(
                new SubEventPrefabXmlReader[] {
                        new EventPrefab0XmlReader()
                }
        );
    }

    @Test
    public void Should_ReturnEventPrefab() {
        assertTrue(EventPrefab0.class.equals(eventPrefabXmlReader
                .readEventPrefab(xmlReader.parse(EVENT_PREFAB_CORRECT_ELEMENT)).getClass()));
    }

    @Test(expected = EventPrefabXmlReadException.class)
    public void Should_ThrowException_When_ElementIsNotCorrectlyFormatted() {
        eventPrefabXmlReader.readEventPrefab(xmlReader.parse(EVENT_PREFAB_INCORRECT_ELEMENT));
    }

    @Test(expected = EventPrefabXmlReadException.class)
    public void Should_ThrowException_When_SubEventFactoryNotFound() {
        eventPrefabXmlReader.readEventPrefab(xmlReader.parse(EVENT_PREFAB_UNKNOWN_TYPE_ELEMENT));
    }

    @Test
    public void Should_ReturnEventPrefabs() {
        assertEquals(2, eventPrefabXmlReader.readEventPrefabs(
                xmlReader.parse(EVENTS_PREFAB_CORRECT_ELEMENT)).size());
    }

    @Test(expected = EventPrefabXmlReadException.class)
    public void Should_ThrowException_When_AtLeastOneElementIsNotCorrectlyFormatted() {
        eventPrefabXmlReader.readEventPrefabs(xmlReader.parse(EVENTS_PREFAB_INCORRECT_ELEMENT));
    }

    @Test(expected = EventPrefabXmlReadException.class)
    public void Should_ThrowException_When_AtLeastOneSubEventFactoryNotFound() {
        eventPrefabXmlReader.readEventPrefab(xmlReader.parse(EVENTS_PREFAB_UNKNOWN_TYPE_ELEMENT));
    }

    private static final class EventPrefab0 extends EventPrefab {
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .toString();
        }
    }

    private static final class EventPrefab0XmlReader implements SubEventPrefabXmlReader<EventPrefab0> {
        @Override
        public EventPrefab0 readEventPrefab(XmlReader.Element element) {
            return new EventPrefab0();
        }

        @Override
        public EventType getReaderType() {
            return EventType.ActivateSystemEvent;
        }
    }
}