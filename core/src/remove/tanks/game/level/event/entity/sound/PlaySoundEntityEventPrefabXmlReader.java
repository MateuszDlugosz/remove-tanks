package remove.tanks.game.level.event.entity.sound;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.audio.sound.SoundChannelName;
import remove.tanks.game.audio.sound.SoundPrefab;
import remove.tanks.game.audio.sound.SoundPrefabXmlReader;
import remove.tanks.game.level.event.EntityEventPrefabXmlReadException;
import remove.tanks.game.level.event.EntityEventType;
import remove.tanks.game.level.event.SubEntityEventPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class PlaySoundEntityEventPrefabXmlReader implements SubEntityEventPrefabXmlReader<PlaySoundEntityEventPrefab> {
    private static final String SOUND_CHANNEL_NAME_ELEMENT = "soundChannelName";

    private final SoundPrefabXmlReader soundPrefabXmlReader;

    public PlaySoundEntityEventPrefabXmlReader(SoundPrefabXmlReader soundPrefabXmlReader) {
        this.soundPrefabXmlReader = soundPrefabXmlReader;
    }

    @Override
    public PlaySoundEntityEventPrefab readEntityEventPrefab(XmlReader.Element element) {
        try {
            return new PlaySoundEntityEventPrefab(
                    readSoundPrefab(element),
                    readSoundChannelName(element)
            );
        } catch (Exception e) {
            throw new EntityEventPrefabXmlReadException(element, e);
        }
    }

    private SoundPrefab readSoundPrefab(XmlReader.Element element) {
        return soundPrefabXmlReader.readSoundPrefab(element.getChildByName(SoundPrefabXmlReader.SOUND_ELEMENT));
    }

    private SoundChannelName readSoundChannelName(XmlReader.Element element) {
        return SoundChannelName.valueOf(element.getChildByName(SOUND_CHANNEL_NAME_ELEMENT).getText().trim());
    }

    @Override
    public EntityEventType getReaderType() {
        return EntityEventType.PlaySoundEntityEvent;
    }
}
