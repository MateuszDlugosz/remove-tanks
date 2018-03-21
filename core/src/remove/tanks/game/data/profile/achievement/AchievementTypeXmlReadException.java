package remove.tanks.game.data.profile.achievement;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class AchievementTypeXmlReadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot read achievement type from element %s.";

    public AchievementTypeXmlReadException(XmlReader.Element element, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, element), cause);
    }
}
