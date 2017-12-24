package remove.tanks.game.level.engine.listener.audio;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.listener.EntityListenerCreateException;
import remove.tanks.game.level.engine.listener.EntityListenerPrototypeXmlLoadException;
import remove.tanks.game.level.engine.listener.ListenerType;
import remove.tanks.game.level.engine.listener.RegistrableEntityListenerPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class SoundListenerPrototypeXmlLoader
        implements RegistrableEntityListenerPrototypeXmlLoader<SoundListenerPrototype>
{
    @Override
    public SoundListenerPrototype loadEntityListenerPrototype(XmlReader.Element element, int priority) {
        try {
            return new SoundListenerPrototype(priority);
        } catch (Exception e) {
            throw new EntityListenerPrototypeXmlLoadException(element, e);
        }
    }

    @Override
    public ListenerType getLoaderType() {
        return ListenerType.SoundListener;
    }
}
