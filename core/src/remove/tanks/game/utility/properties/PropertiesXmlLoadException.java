package remove.tanks.game.utility.properties;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class PropertiesXmlLoadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot load properties from element %s.";

    public PropertiesXmlLoadException(XmlReader.Element element, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, element), cause);
    }
}
