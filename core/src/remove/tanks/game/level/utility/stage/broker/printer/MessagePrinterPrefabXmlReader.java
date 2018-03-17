package remove.tanks.game.level.utility.stage.broker.printer;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.audio.sound.SoundChannelName;
import remove.tanks.game.audio.sound.SoundPrefab;
import remove.tanks.game.audio.sound.SoundPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class MessagePrinterPrefabXmlReader {
    public static final String MESSAGE_PRINTER_ELEMENT = "messagePrinter";

    private static final String TIME_ELEMENT = "time";
    private static final String SOUND_CHANNEL_NAME_ELEMENT = "soundChannelName";

    private final SoundPrefabXmlReader soundPrefabXmlReader;

    public MessagePrinterPrefabXmlReader(SoundPrefabXmlReader soundPrefabXmlReader) {
        this.soundPrefabXmlReader = soundPrefabXmlReader;
    }

    public MessagePrinterPrefab readMessagePrinterPrefab(XmlReader.Element element) {
        try {
            return new MessagePrinterPrefab(
                    readTime(element),
                    readSoundPrefab(element),
                    readSoundChannelName(element)
            );
        } catch (Exception e) {
            throw new MessagePrinterPrefabXmlReadException(element, e);
        }
    }

    private float readTime(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(TIME_ELEMENT).getText().trim());
    }

    private SoundPrefab readSoundPrefab(XmlReader.Element element) {
        return soundPrefabXmlReader.readSoundPrefab(
                element.getChildByName(SoundPrefabXmlReader.SOUND_ELEMENT)
        );
    }

    private SoundChannelName readSoundChannelName(XmlReader.Element element) {
        return SoundChannelName.valueOf(element.getChildByName(SOUND_CHANNEL_NAME_ELEMENT).getText().trim());
    }
}
