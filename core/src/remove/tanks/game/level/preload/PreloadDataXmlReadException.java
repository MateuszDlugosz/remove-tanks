package remove.tanks.game.level.preload;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class PreloadDataXmlReadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot read preload data from element %s.";

    public PreloadDataXmlReadException(XmlReader.Element element, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, element), cause);
    }
}
