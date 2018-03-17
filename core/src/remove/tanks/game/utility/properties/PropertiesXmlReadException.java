package remove.tanks.game.utility.properties;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class PropertiesXmlReadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot read properties from element %s.";

    public PropertiesXmlReadException(XmlReader.Element element, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, element), cause);
    }
}
