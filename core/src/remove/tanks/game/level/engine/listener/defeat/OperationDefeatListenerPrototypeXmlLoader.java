package remove.tanks.game.level.engine.listener.defeat;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.listener.ListenerType;
import remove.tanks.game.level.engine.listener.RegistrableEntityListenerPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class OperationDefeatListenerPrototypeXmlLoader
        extends RegistrableEntityListenerPrototypeXmlLoader<OperationDefeatListenerPrototype>
{
    @Override
    protected OperationDefeatListenerPrototype loadEntityListenerPrototype(XmlReader.Element element, int priority) {
        return new OperationDefeatListenerPrototype(priority);
    }

    @Override
    public ListenerType getLoaderType() {
        return ListenerType.OperationDefeatListener;
    }
}
