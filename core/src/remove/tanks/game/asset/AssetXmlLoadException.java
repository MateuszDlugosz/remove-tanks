package remove.tanks.game.asset;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class AssetXmlLoadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot load asset prototype from element %s.";

    public AssetXmlLoadException(XmlReader.Element element, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, element), cause);
    }
}
