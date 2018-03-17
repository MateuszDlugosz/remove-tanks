package remove.tanks.game.level.event.message;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EventPrefabXmlReadException;
import remove.tanks.game.level.event.EventType;
import remove.tanks.game.level.event.SubEventPrefabXmlReader;
import remove.tanks.game.level.utility.stage.broker.message.MessagePrefab;
import remove.tanks.game.level.utility.stage.broker.message.MessagePrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class AddMessageEventPrefabXmlReader implements SubEventPrefabXmlReader<AddMessageEventPrefab> {
    private final MessagePrefabXmlReader messagePrefabXmlReader;

    public AddMessageEventPrefabXmlReader(MessagePrefabXmlReader messagePrefabXmlReader) {
        this.messagePrefabXmlReader = messagePrefabXmlReader;
    }

    @Override
    public AddMessageEventPrefab readEventPrefab(XmlReader.Element element) {
        try {
            return new AddMessageEventPrefab(readMessagePrefab(element));
        } catch (Exception e) {
            throw new EventPrefabXmlReadException(element, e);
        }
    }

    private MessagePrefab readMessagePrefab(XmlReader.Element element) {
        return messagePrefabXmlReader.readMessagePrefab(element.getChildByName(MessagePrefabXmlReader.MESSAGE_ELEMENT));
    }

    @Override
    public EventType getReaderType() {
        return EventType.AddMessageEvent;
    }
}
