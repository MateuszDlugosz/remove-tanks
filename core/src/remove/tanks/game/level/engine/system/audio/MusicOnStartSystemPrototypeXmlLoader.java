package remove.tanks.game.level.engine.system.audio;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.audio.music.MusicPrototype;
import remove.tanks.game.audio.music.MusicPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.EntitySystemPrototypeXmlLoadException;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class MusicOnStartSystemPrototypeXmlLoader
        implements RegistrableEntitySystemPrototypeXmlLoader<MusicOnStartSystemPrototype>
{
    private final MusicPrototypeXmlLoader musicPrototypeXmlLoader;

    public MusicOnStartSystemPrototypeXmlLoader(MusicPrototypeXmlLoader musicPrototypeXmlLoader) {
        this.musicPrototypeXmlLoader = musicPrototypeXmlLoader;
    }

    @Override
    public MusicOnStartSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        try {
            return new MusicOnStartSystemPrototype(
                    priority,
                    loadMusicPrototype(element)
            );
        } catch (Exception e) {
            throw new EntitySystemPrototypeXmlLoadException(element, e);
        }
    }

    private MusicPrototype loadMusicPrototype(XmlReader.Element element) {
        return musicPrototypeXmlLoader.loadMusicPrototype(
                element.getChildByName(MusicPrototypeXmlLoader.MUSIC_ELEMENT)
        );
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.MusicOnStartSystem;
    }
}
