package remove.tanks.game.asset;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class AssetIdXmlReadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot read asset id from element %s.";

    public AssetIdXmlReadException(XmlReader.Element element, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, element), cause);
    }
}
