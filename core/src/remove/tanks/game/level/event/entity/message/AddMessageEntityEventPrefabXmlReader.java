package remove.tanks.game.level.event.entity.message;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EntityEventPrefabXmlReadException;
import remove.tanks.game.level.event.EntityEventType;
import remove.tanks.game.level.event.SubEntityEventPrefabXmlReader;
import remove.tanks.game.level.utility.stage.broker.message.MessagePrefab;
import remove.tanks.game.level.utility.stage.broker.message.MessagePrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class AddMessageEntityEventPrefabXmlReader implements SubEntityEventPrefabXmlReader<AddMessageEntityEventPrefab> {
    private final MessagePrefabXmlReader messagePrefabXmlReader;

    public AddMessageEntityEventPrefabXmlReader(MessagePrefabXmlReader messagePrefabXmlReader) {
        this.messagePrefabXmlReader = messagePrefabXmlReader;
    }

    @Override
    public AddMessageEntityEventPrefab readEntityEventPrefab(XmlReader.Element element) {
        try {
            return new AddMessageEntityEventPrefab(readMessagePrefab(element));
        } catch (Exception e) {
            throw new EntityEventPrefabXmlReadException(element, e);
        }
    }

    private MessagePrefab readMessagePrefab(XmlReader.Element element) {
        return messagePrefabXmlReader.readMessagePrefab(element.getChildByName(MessagePrefabXmlReader.MESSAGE_ELEMENT));
    }

    @Override
    public EntityEventType getReaderType() {
        return EntityEventType.AddMessageEntityEvent;
    }
}
