package remove.tanks.game.level.engine.system.hud.stages.broker.face;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class FacePrototypeXmlLoadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot load face prototype from element %s.";

    public FacePrototypeXmlLoadException(XmlReader.Element element, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, element), cause);
    }
}
