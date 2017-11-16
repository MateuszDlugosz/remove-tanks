package remove.tanks.game.level.engine.entity.component.audio;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.audio.sound.SoundPrototype;
import remove.tanks.game.audio.sound.SoundPrototypeXmlLoader;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class SoundOnDestroyComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<SoundOnDestroyComponentPrototype>
{
    private final SoundPrototypeXmlLoader soundPrototypeXmlLoader;

    public SoundOnDestroyComponentPrototypeXmlLoader(SoundPrototypeXmlLoader soundPrototypeXmlLoader) {
        this.soundPrototypeXmlLoader = soundPrototypeXmlLoader;
    }

    @Override
    public SoundOnDestroyComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        return new SoundOnDestroyComponentPrototype(
                loadSoundPrototypes(element)
        );
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
        return ComponentType.SoundOnDestroyComponent;
    }
}
