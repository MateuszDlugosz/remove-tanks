package remove.tanks.game.level.engine.listener.trigger;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.listener.ListenerType;

/**
 * @author Mateusz Długosz
 */
public final class HitTriggerListenerPrefabXmlReader extends AbstractTriggerListenerPrefabXmlReader<HitTriggerListenerPrefab> {
    @Override
    protected HitTriggerListenerPrefab readTriggerEntityListener(XmlReader.Element element, int priority) {
        return new HitTriggerListenerPrefab(priority);
    }

    @Override
    public ListenerType getReaderType() {
        return ListenerType.HitTriggerListener;
    }
}
