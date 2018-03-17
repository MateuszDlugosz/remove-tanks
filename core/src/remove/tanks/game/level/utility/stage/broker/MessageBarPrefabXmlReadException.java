package remove.tanks.game.level.utility.stage.broker;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class MessageBarPrefabXmlReadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot read message bar prefab from element %s.";

    public MessageBarPrefabXmlReadException(XmlReader.Element element, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, element), cause);
    }
}
