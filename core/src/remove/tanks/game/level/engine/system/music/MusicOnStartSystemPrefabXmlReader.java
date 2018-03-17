package remove.tanks.game.level.engine.system.music;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.audio.music.MusicChannelName;
import remove.tanks.game.audio.music.MusicPrefab;
import remove.tanks.game.audio.music.MusicPrefabXmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrefabXmlReadException;
import remove.tanks.game.level.engine.system.SubEntitySystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class MusicOnStartSystemPrefabXmlReader implements SubEntitySystemPrefabXmlReader<MusicOnStartSystemPrefab> {
    private static final String MUSIC_CHANNEL_NAME_ELEMENT = "musicChannelName";

    private final MusicPrefabXmlReader musicPrefabXmlReader;

    public MusicOnStartSystemPrefabXmlReader(MusicPrefabXmlReader musicPrefabXmlReader) {
        this.musicPrefabXmlReader = musicPrefabXmlReader;
    }

    @Override
    public MusicOnStartSystemPrefab readEntitySystemPrefab(XmlReader.Element element, int priority) {
        try {
            return new MusicOnStartSystemPrefab(
                    priority,
                    readMusicPrefab(element),
                    readMusicChannelName(element)
            );
        } catch (Exception e) {
            throw new EntitySystemPrefabXmlReadException(element, e);
        }
    }

    private MusicPrefab readMusicPrefab(XmlReader.Element element) {
        return musicPrefabXmlReader.readMusicPrefab(element.getChildByName(MusicPrefabXmlReader.MUSIC_ELEMENT));
    }

    private MusicChannelName readMusicChannelName(XmlReader.Element element) {
        return MusicChannelName.valueOf(element.getChildByName(MUSIC_CHANNEL_NAME_ELEMENT).getText().trim());
    }

    @Override
    public SystemType getReaderType() {
        return SystemType.MusicOnStartSystem;
    }
}
