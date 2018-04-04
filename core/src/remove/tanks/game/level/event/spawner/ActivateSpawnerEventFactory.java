package remove.tanks.game.level.event.spawner;

import remove.tanks.game.level.event.EventCreateException;
import remove.tanks.game.level.event.SubEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class ActivateSpawnerEventFactory implements SubEventFactory<ActivateSpawnerEvent, ActivateSpawnerEventPrefab> {
    @Override
    public ActivateSpawnerEvent createEvent(ActivateSpawnerEventPrefab prefab, ResourceRegistry registry) {
        try {
            return new ActivateSpawnerEvent(prefab.getId());
        } catch (Exception e) {
            throw new EventCreateException(prefab, e);
        }
    }

    @Override
    public Class<ActivateSpawnerEventPrefab> getFactoryType() {
        return ActivateSpawnerEventPrefab.class;
    }
}
