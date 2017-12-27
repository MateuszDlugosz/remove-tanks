package remove.tanks.game.level.engine.system.hud.stages.broker.printer;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class MessagePrinterPrototypeXmlLoadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot load message printer prototype from element %s.";

    public MessagePrinterPrototypeXmlLoadException(XmlReader.Element element, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, element), cause);
    }
}
