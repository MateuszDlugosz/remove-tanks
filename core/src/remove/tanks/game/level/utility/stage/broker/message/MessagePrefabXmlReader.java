package remove.tanks.game.level.utility.stage.broker.message;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class MessagePrefabXmlReader {
    public static final String MESSAGE_ELEMENT = "message";

    private static final String TIME_ELEMENT = "time";
    private static final String ENTRY_KEY_ELEMENT = "entryKey";
    private static final String FACE_ID_ELEMENT = "faceId";

    public MessagePrefab readMessagePrefab(XmlReader.Element element) {
        try {
            return new MessagePrefab(
                    readTime(element),
                    readEntryKey(element),
                    readFaceId(element)
            );
        } catch (Exception e) {
            throw new MessagePrefabXmlReadException(element, e);
        }
    }

    private float readTime(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(TIME_ELEMENT).getText().trim());
    }

    private String readEntryKey(XmlReader.Element element) {
        return element.getChildByName(ENTRY_KEY_ELEMENT).getText().trim();
    }

    private String readFaceId(XmlReader.Element element) {
        if (element.getChildByName(FACE_ID_ELEMENT) == null) {
            return null;
        }
        return element.getChildByName(FACE_ID_ELEMENT).getText().trim();
    }
}
