package remove.tanks.game.asset.parameter;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class ParametersPrefabXmlReadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot read asset loader parameter prefab from element %s.";

    public ParametersPrefabXmlReadException(XmlReader.Element element, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, element), cause);
    }
}
