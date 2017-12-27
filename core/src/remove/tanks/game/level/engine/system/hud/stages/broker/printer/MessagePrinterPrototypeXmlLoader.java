package remove.tanks.game.level.engine.system.hud.stages.broker.printer;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.audio.sound.SoundPrototype;
import remove.tanks.game.audio.sound.SoundPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class MessagePrinterPrototypeXmlLoader {
    public static final String MESSAGE_PRINTER_ELEMENT = "messagePrinter";

    private static final String TIME_ELEMENT = "time";

    private final SoundPrototypeXmlLoader soundPrototypeXmlLoader;

    public MessagePrinterPrototypeXmlLoader(SoundPrototypeXmlLoader soundPrototypeXmlLoader) {
        this.soundPrototypeXmlLoader = soundPrototypeXmlLoader;
    }

    public MessagePrinterPrototype loadMessagePrinterPrototype(XmlReader.Element element) {
        try {
            return new MessagePrinterPrototype(
                    loadTime(element),
                    loadSoundPrototype(element)
            );
        } catch (Exception e) {
            throw new MessagePrinterPrototypeXmlLoadException(element, e);
        }
    }

    private float loadTime(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(TIME_ELEMENT).getText().trim());
    }

    private SoundPrototype loadSoundPrototype(XmlReader.Element element) {
        return soundPrototypeXmlLoader.loadSoundPrototype(
                element.getChildByName(SoundPrototypeXmlLoader.SOUND_ELEMENT)
        );
    }
}
