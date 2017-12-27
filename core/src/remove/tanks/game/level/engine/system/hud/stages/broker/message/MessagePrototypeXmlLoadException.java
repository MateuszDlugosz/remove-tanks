package remove.tanks.game.level.engine.system.hud.stages.broker.message;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class MessagePrototypeXmlLoadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot load message prototype from element %s.";

    public MessagePrototypeXmlLoadException(XmlReader.Element element, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, element), cause);
    }
}
