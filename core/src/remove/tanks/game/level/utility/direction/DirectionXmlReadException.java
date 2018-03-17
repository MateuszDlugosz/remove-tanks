package remove.tanks.game.level.utility.direction;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class DirectionXmlReadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot read direction from element %s.";

    public DirectionXmlReadException(XmlReader.Element element, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, element), cause);
    }
}
