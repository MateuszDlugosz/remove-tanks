package remove.tanks.game.level.engine.utility.direction;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class DirectionXmlLoadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot load direction from element %s.";

    public DirectionXmlLoadException(XmlReader.Element element, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, element), cause);
    }
}
