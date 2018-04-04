package remove.tanks.game.level.event.entity.message;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.event.EntityEventCreateException;
import remove.tanks.game.level.event.SubEntityEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class ClearMessagesEntityEventFactory implements SubEntityEventFactory<ClearMessagesEntityEvent, ClearMessagesEntityEventPrefab> {
    @Override
    public ClearMessagesEntityEvent createEntityEvent(ClearMessagesEntityEventPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new ClearMessagesEntityEvent(entity);
        } catch (Exception e) {
            throw new EntityEventCreateException(prefab, e);
        }
    }

    @Override
    public Class<ClearMessagesEntityEventPrefab> getFactoryType() {
        return ClearMessagesEntityEventPrefab.class;
    }
}
