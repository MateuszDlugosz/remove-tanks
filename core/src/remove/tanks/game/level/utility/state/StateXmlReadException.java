package remove.tanks.game.level.utility.state;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class StateXmlReadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot read state from element %s.";

    public StateXmlReadException(XmlReader.Element element, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, element), cause);
    }
}
