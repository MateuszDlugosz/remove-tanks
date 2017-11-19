package remove.tanks.game.level.engine.system.audio;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.audio.music.MusicPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class MusicOnStartSystemPrototypeXmlLoader
        extends RegistrableEntitySystemPrototypeXmlLoader<MusicOnStartSystemPrototype>
{
    private final MusicPrototypeXmlLoader musicPrototypeXmlLoader;

    public MusicOnStartSystemPrototypeXmlLoader(MusicPrototypeXmlLoader musicPrototypeXmlLoader) {
        this.musicPrototypeXmlLoader = musicPrototypeXmlLoader;
    }

    @Override
    protected MusicOnStartSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        return new MusicOnStartSystemPrototype(
                priority,
                musicPrototypeXmlLoader.loadMusicPrototype(
                        element.getChildByName(MusicPrototypeXmlLoader.MUSIC_ELEMENT)
                )
        );
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.MusicOnStartSystem;
    }
}
