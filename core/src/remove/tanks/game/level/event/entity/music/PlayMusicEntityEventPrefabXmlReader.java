package remove.tanks.game.level.event.entity.music;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.audio.music.MusicChannelName;
import remove.tanks.game.audio.music.MusicPrefab;
import remove.tanks.game.audio.music.MusicPrefabXmlReader;
import remove.tanks.game.level.event.EntityEventPrefabXmlReadException;
import remove.tanks.game.level.event.EntityEventType;
import remove.tanks.game.level.event.SubEntityEventPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class PlayMusicEntityEventPrefabXmlReader implements SubEntityEventPrefabXmlReader<PlayMusicEntityEventPrefab> {
    private static final String MUSIC_CHANNEL_NAME_ELEMENT = "musicChannelName";

    private final MusicPrefabXmlReader musicPrefabXmlReader;

    public PlayMusicEntityEventPrefabXmlReader(MusicPrefabXmlReader musicPrefabXmlReader) {
        this.musicPrefabXmlReader = musicPrefabXmlReader;
    }

    @Override
    public PlayMusicEntityEventPrefab readEntityEventPrefab(XmlReader.Element element) {
        try {
            return new PlayMusicEntityEventPrefab(
                    readMusicPrefab(element),
                    readMusicChannelName(element)
            );
        } catch (Exception e) {
            throw new EntityEventPrefabXmlReadException(element, e);
        }
    }

    private MusicPrefab readMusicPrefab(XmlReader.Element element) {
        return musicPrefabXmlReader.readMusicPrefab(element.getChildByName(MusicPrefabXmlReader.MUSIC_ELEMENT));
    }

    private MusicChannelName readMusicChannelName(XmlReader.Element element) {
        return MusicChannelName.valueOf(element.getChildByName(MUSIC_CHANNEL_NAME_ELEMENT).getText().trim());
    }

    @Override
    public EntityEventType getReaderType() {
        return EntityEventType.PlayMusicEntityEvent;
    }
}
