package remove.tanks.game.level.resource.configuration;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class ResourceConfigurationsXmlReadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot read resource configuration from element %s.";

    public ResourceConfigurationsXmlReadException(XmlReader.Element element, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, element), cause);
    }
}
