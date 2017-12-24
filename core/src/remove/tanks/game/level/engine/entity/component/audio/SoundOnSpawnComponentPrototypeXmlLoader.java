package remove.tanks.game.level.engine.entity.component.audio;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.audio.sound.SoundPrototype;
import remove.tanks.game.audio.sound.SoundPrototypeXmlLoader;
import remove.tanks.game.level.engine.entity.component.ComponentPrototypeXmlLoadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class SoundOnSpawnComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<SoundOnSpawnComponentPrototype>
{
    private final SoundPrototypeXmlLoader soundPrototypeXmlLoader;

    public SoundOnSpawnComponentPrototypeXmlLoader(SoundPrototypeXmlLoader soundPrototypeXmlLoader) {
        this.soundPrototypeXmlLoader = soundPrototypeXmlLoader;
    }

    @Override
    public SoundOnSpawnComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        try {
            return new SoundOnSpawnComponentPrototype(
                    loadSoundPrototypes(element)
            );
        } catch (Exception e) {
            throw new ComponentPrototypeXmlLoadException(element, e);
        }
    }

    private List<SoundPrototype> loadSoundPrototypes(XmlReader.Element element) {
        if (element.getChildByName(SoundPrototypeXmlLoader.SOUNDS_ELEMENT) == null) {
            return new ArrayList<>();
        }
        return soundPrototypeXmlLoader.loadSoundPrototypes(
                element.getChildByName(SoundPrototypeXmlLoader.SOUNDS_ELEMENT)
        );
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.SoundOnSpawnComponent;
    }
}
