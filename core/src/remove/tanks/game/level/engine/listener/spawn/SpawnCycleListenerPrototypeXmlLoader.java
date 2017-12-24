package remove.tanks.game.level.engine.listener.spawn;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.listener.EntityListenerPrototypeXmlLoadException;
import remove.tanks.game.level.engine.listener.ListenerType;
import remove.tanks.game.level.engine.listener.RegistrableEntityListenerPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class SpawnCycleListenerPrototypeXmlLoader
        implements RegistrableEntityListenerPrototypeXmlLoader<SpawnCycleListenerPrototype>
{
    @Override
    public SpawnCycleListenerPrototype loadEntityListenerPrototype(XmlReader.Element element, int priority) {
        try {
            return new SpawnCycleListenerPrototype(priority);
        } catch (Exception e) {
            throw new EntityListenerPrototypeXmlLoadException(element, e);
        }
    }

    @Override
    public ListenerType getLoaderType() {
        return ListenerType.SpawnCycleListener;
    }
}
