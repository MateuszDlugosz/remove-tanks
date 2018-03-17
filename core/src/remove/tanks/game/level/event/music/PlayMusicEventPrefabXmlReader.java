package remove.tanks.game.level.event.music;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.audio.music.MusicChannelName;
import remove.tanks.game.audio.music.MusicPrefab;
import remove.tanks.game.audio.music.MusicPrefabXmlReader;
import remove.tanks.game.level.event.EventPrefabXmlReadException;
import remove.tanks.game.level.event.EventType;
import remove.tanks.game.level.event.SubEventPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class PlayMusicEventPrefabXmlReader implements SubEventPrefabXmlReader<PlayMusicEventPrefab> {
    private static final String MUSIC_CHANNEL_NAME_ELEMENT = "musicChannelName";

    private final MusicPrefabXmlReader musicPrefabXmlReader;

    public PlayMusicEventPrefabXmlReader(MusicPrefabXmlReader musicPrefabXmlReader) {
        this.musicPrefabXmlReader = musicPrefabXmlReader;
    }

    @Override
    public PlayMusicEventPrefab readEventPrefab(XmlReader.Element element) {
        try {
            return new PlayMusicEventPrefab(
                    readMusicPrefab(element),
                    readMusicChannelName(element)
            );
        } catch (Exception e) {
            throw new EventPrefabXmlReadException(element, e);
        }
    }

    private MusicPrefab readMusicPrefab(XmlReader.Element element) {
        return musicPrefabXmlReader.readMusicPrefab(element.getChildByName(MusicPrefabXmlReader.MUSIC_ELEMENT));
    }

    private MusicChannelName readMusicChannelName(XmlReader.Element element) {
        return MusicChannelName.valueOf(element.getChildByName(MUSIC_CHANNEL_NAME_ELEMENT).getText().trim());
    }

    @Override
    public EventType getReaderType() {
        return EventType.PlayMusicEvent;
    }
}
