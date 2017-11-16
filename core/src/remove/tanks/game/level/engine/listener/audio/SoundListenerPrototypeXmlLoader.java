package remove.tanks.game.level.engine.listener.audio;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.listener.ListenerType;
import remove.tanks.game.level.engine.listener.RegistrableEntityListenerPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class SoundListenerPrototypeXmlLoader
        extends RegistrableEntityListenerPrototypeXmlLoader<SoundListenerPrototype>
{
    @Override
    protected SoundListenerPrototype loadEntityListenerPrototype(XmlReader.Element element, int priority) {
        return new SoundListenerPrototype(priority);
    }

    @Override
    public ListenerType getLoaderType() {
        return ListenerType.SoundListener;
    }
}
