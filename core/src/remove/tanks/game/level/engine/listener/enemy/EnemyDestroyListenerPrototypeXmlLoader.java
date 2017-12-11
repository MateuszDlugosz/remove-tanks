package remove.tanks.game.level.engine.listener.enemy;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.listener.ListenerType;
import remove.tanks.game.level.engine.listener.RegistrableEntityListenerPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class EnemyDestroyListenerPrototypeXmlLoader
        implements RegistrableEntityListenerPrototypeXmlLoader<EnemyDestroyListenerPrototype>
{
    @Override
    public EnemyDestroyListenerPrototype loadEntityListenerPrototype(XmlReader.Element element, int priority) {
        return new EnemyDestroyListenerPrototype(priority);
    }

    @Override
    public ListenerType getLoaderType() {
        return ListenerType.EnemyDestroyListener;
    }
}
