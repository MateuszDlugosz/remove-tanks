package remove.tanks.game.level;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class LevelSequenceXmlLoadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot load operation prototype from element %s.";

    public LevelSequenceXmlLoadException(XmlReader.Element element, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, element), cause);
    }
}
