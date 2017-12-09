package remove.tanks.game.audio.sound;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class SoundPrototypeXmlLoadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot load sound prototype from element %s.";

    public SoundPrototypeXmlLoadException(XmlReader.Element element, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, element), cause);
    }
}
