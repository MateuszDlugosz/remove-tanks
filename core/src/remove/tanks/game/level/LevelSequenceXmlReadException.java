package remove.tanks.game.level;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class LevelSequenceXmlReadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot read level sequence from element %s.";

    public LevelSequenceXmlReadException(XmlReader.Element element, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, element), cause);
    }
}
