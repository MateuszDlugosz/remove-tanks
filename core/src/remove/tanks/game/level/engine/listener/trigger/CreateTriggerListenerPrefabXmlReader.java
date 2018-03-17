package remove.tanks.game.level.engine.listener.trigger;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.listener.ListenerType;

/**
 * @author Mateusz Długosz
 */
public final class CreateTriggerListenerPrefabXmlReader extends AbstractTriggerListenerPrefabXmlReader<CreateTriggerListenerPrefab> {
    @Override
    protected CreateTriggerListenerPrefab readTriggerEntityListener(XmlReader.Element element, int priority) {
        return new CreateTriggerListenerPrefab(priority);
    }

    @Override
    public ListenerType getReaderType() {
        return ListenerType.CreateTriggerListener;
    }
}
