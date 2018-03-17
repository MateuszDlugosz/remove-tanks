package remove.tanks.game.graphics.view;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class ViewPrefabXmlReadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot read view prefab from element %s.";

    public ViewPrefabXmlReadException(XmlReader.Element element, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, element), cause);
    }
}
