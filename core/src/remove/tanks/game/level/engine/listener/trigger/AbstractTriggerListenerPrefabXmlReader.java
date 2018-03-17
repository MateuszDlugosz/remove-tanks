package remove.tanks.game.level.engine.listener.trigger;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.listener.EntityListenerPrefabXmlReadException;
import remove.tanks.game.level.engine.listener.ListenerType;
import remove.tanks.game.level.engine.listener.SubEntityListenerPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public abstract class AbstractTriggerListenerPrefabXmlReader<T extends AbstractTriggerListenerPrefab>
        implements SubEntityListenerPrefabXmlReader<T>
{

    @Override
    public final T readEntityListenerPrefab(XmlReader.Element element, int priority) {
        try {
            return readTriggerEntityListener(element, priority);
        } catch (Exception e) {
            throw new EntityListenerPrefabXmlReadException(element, e);
        }
    }

    protected abstract T readTriggerEntityListener(XmlReader.Element element, int priority);

    @Override
    public abstract ListenerType getReaderType();
}
