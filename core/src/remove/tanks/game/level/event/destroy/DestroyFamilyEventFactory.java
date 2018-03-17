package remove.tanks.game.level.event.destroy;

import remove.tanks.game.level.event.EventCreateException;
import remove.tanks.game.level.event.SubEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class DestroyFamilyEventFactory implements SubEventFactory<DestroyFamilyEvent, DestroyFamilyEventPrefab> {
    @Override
    public DestroyFamilyEvent createEvent(DestroyFamilyEventPrefab prefab, ResourceRegistry registry) {
        try {
            return new DestroyFamilyEvent(prefab.getEntityFamily());
        } catch (Exception e) {
            throw new EventCreateException(prefab, e);
        }
    }

    @Override
    public Class<DestroyFamilyEventPrefab> getFactoryType() {
        return DestroyFamilyEventPrefab.class;
    }
}
