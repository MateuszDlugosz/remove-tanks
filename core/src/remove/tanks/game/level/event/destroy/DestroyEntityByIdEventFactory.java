package remove.tanks.game.level.event.destroy;

import remove.tanks.game.level.event.EventCreateException;
import remove.tanks.game.level.event.SubEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class DestroyEntityByIdEventFactory implements SubEventFactory<DestroyEntityByIdEvent, DestroyEntityByIdEventPrefab> {
    @Override
    public DestroyEntityByIdEvent createEvent(DestroyEntityByIdEventPrefab prefab, ResourceRegistry registry) {
        try {
            return new DestroyEntityByIdEvent(prefab.getId());
        } catch (Exception e) {
            throw new EventCreateException(prefab, e);
        }
    }

    @Override
    public Class<DestroyEntityByIdEventPrefab> getFactoryType() {
        return DestroyEntityByIdEventPrefab.class;
    }
}
