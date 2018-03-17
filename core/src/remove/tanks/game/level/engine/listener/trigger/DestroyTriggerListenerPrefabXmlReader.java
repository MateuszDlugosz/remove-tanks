package remove.tanks.game.level.engine.listener.trigger;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.listener.ListenerType;

/**
 * @author Mateusz Długosz
 */
public final class DestroyTriggerListenerPrefabXmlReader extends AbstractTriggerListenerPrefabXmlReader<DestroyTriggerListenerPrefab> {
    @Override
    protected DestroyTriggerListenerPrefab readTriggerEntityListener(XmlReader.Element element, int priority) {
        return new DestroyTriggerListenerPrefab(priority);
    }

    @Override
    public ListenerType getReaderType() {
        return ListenerType.DestroyTriggerListener;
    }
}
