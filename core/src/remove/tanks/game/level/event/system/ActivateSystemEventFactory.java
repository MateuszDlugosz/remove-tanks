package remove.tanks.game.level.event.system;

import com.badlogic.ashley.core.EntitySystem;
import remove.tanks.game.level.event.EventCreateException;
import remove.tanks.game.level.event.SubEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class ActivateSystemEventFactory implements SubEventFactory<ActivateSystemEvent, ActivateSystemEventPrefab> {
    @Override
    public ActivateSystemEvent createEvent(ActivateSystemEventPrefab prefab, ResourceRegistry registry) {
        try {
            return new ActivateSystemEvent(
                    createSystemClass(prefab.getSystemClass())
            );
        } catch (Exception e) {
            throw new EventCreateException(prefab, e);
        }
    }

    @SuppressWarnings("unchecked")
    private Class<? extends EntitySystem> createSystemClass(String className) throws ClassNotFoundException {
        return (Class<? extends EntitySystem>) Class.forName(className);
    }

    @Override
    public Class<ActivateSystemEventPrefab> getFactoryType() {
        return ActivateSystemEventPrefab.class;
    }
}
