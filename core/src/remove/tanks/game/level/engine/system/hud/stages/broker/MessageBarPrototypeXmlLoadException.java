package remove.tanks.game.level.engine.system.hud.stages.broker;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class MessageBarPrototypeXmlLoadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot load message bar prototype from element %s.";

    public MessageBarPrototypeXmlLoadException(XmlReader.Element element, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, element), cause);
    }
}
