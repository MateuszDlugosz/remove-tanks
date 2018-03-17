package remove.tanks.game.level.utility.timeline;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class TimelineEntryXmlReadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot read timeline entry prefab from element %s.";

    public TimelineEntryXmlReadException(XmlReader.Element element, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, element), cause);
    }
}
