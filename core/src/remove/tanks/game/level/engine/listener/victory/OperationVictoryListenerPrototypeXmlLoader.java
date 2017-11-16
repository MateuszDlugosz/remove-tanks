package remove.tanks.game.level.engine.listener.victory;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.listener.ListenerType;
import remove.tanks.game.level.engine.listener.RegistrableEntityListenerPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class OperationVictoryListenerPrototypeXmlLoader
        extends RegistrableEntityListenerPrototypeXmlLoader<OperationVictoryListenerPrototype>
{
    @Override
    protected OperationVictoryListenerPrototype loadEntityListenerPrototype(XmlReader.Element element, int priority) {
        return new OperationVictoryListenerPrototype(priority);
    }

    @Override
    public ListenerType getLoaderType() {
        return ListenerType.OperationVictoryListener;
    }
}
