package remove.tanks.game.level.engine.system.hud.stages.message;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class MessageBarPrototypeXmlLoader {
    public static final String  MESSAGE_BAR_ELEMENT = "messageBar";

    private static final String DEFAULT_MESSAGE_ELEMENT = "defaultMessage";

    public MessageBarPrototype loadMessageBarPrototype(XmlReader.Element element) {
        try {
            return new MessageBarPrototype(
                    loadDefaultMessage(element)
            );
        } catch (Exception e) {
            throw new MessageBarPrototypeXmlLoadException(element, e);
        }
    }

    private String loadDefaultMessage(XmlReader.Element element) {
        return element.getChildByName(DEFAULT_MESSAGE_ELEMENT).getText();
    }
}
