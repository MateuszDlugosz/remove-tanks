package remove.tanks.game.level.event.entity.system;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import remove.tanks.game.level.event.EventCreateException;
import remove.tanks.game.level.event.SubEntityEventFactory;
import remove.tanks.game.level.event.SubEventFactory;
import remove.tanks.game.level.event.system.ActivateSystemEvent;
import remove.tanks.game.level.event.system.ActivateSystemEventPrefab;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class ActivateSystemEntityEventFactory implements SubEntityEventFactory<ActivateSystemEntityEvent, ActivateSystemEntityEventPrefab> {
    @Override
    public ActivateSystemEntityEvent createEntityEvent(ActivateSystemEntityEventPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new ActivateSystemEntityEvent(
                    entity,
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
    public Class<ActivateSystemEntityEventPrefab> getFactoryType() {
        return ActivateSystemEntityEventPrefab.class;
    }
}
