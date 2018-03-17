package remove.tanks.game.level.event.sound;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.audio.sound.SoundChannelName;
import remove.tanks.game.audio.sound.SoundPrefab;
import remove.tanks.game.audio.sound.SoundPrefabXmlReader;
import remove.tanks.game.level.event.EventPrefabXmlReadException;
import remove.tanks.game.level.event.EventType;
import remove.tanks.game.level.event.SubEventPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class PlaySoundEventPrefabXmlReader implements SubEventPrefabXmlReader<PlaySoundEventPrefab> {
    private static final String SOUND_CHANNEL_NAME_ELEMENT = "soundChannelName";

    private final SoundPrefabXmlReader soundPrefabXmlReader;

    public PlaySoundEventPrefabXmlReader(SoundPrefabXmlReader soundPrefabXmlReader) {
        this.soundPrefabXmlReader = soundPrefabXmlReader;
    }

    @Override
    public PlaySoundEventPrefab readEventPrefab(XmlReader.Element element) {
        try {
            return new PlaySoundEventPrefab(
                    readSoundPrefab(element),
                    readSoundChannelName(element)
            );
        } catch (Exception e) {
            throw new EventPrefabXmlReadException(element, e);
        }
    }

    private SoundPrefab readSoundPrefab(XmlReader.Element element) {
        return soundPrefabXmlReader.readSoundPrefab(element.getChildByName(SoundPrefabXmlReader.SOUND_ELEMENT));
    }

    private SoundChannelName readSoundChannelName(XmlReader.Element element) {
        return SoundChannelName.valueOf(element.getChildByName(SOUND_CHANNEL_NAME_ELEMENT).getText().trim());
    }

    @Override
    public EventType getReaderType() {
        return EventType.PlaySoundEvent;
    }
}
