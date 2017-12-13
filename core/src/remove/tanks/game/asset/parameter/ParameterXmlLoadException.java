package remove.tanks.game.asset.parameter;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class ParameterXmlLoadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot load asset loader parameter prototype from element %s.";

    public ParameterXmlLoadException(XmlReader.Element element, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, element), cause);
    }
}
