package remove.tanks.game.level.engine.listener.trigger;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.listener.ListenerType;
import remove.tanks.game.level.engine.listener.RegistrableEntityListenerPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class TriggerListenerPrototypeXmlLoader
        implements RegistrableEntityListenerPrototypeXmlLoader<TriggerListenerPrototype>
{
    @Override
    public TriggerListenerPrototype loadEntityListenerPrototype(XmlReader.Element element, int priority) {
        return new TriggerListenerPrototype(priority);
    }

    @Override
    public ListenerType getLoaderType() {
        return ListenerType.TriggerListener;
    }
}
