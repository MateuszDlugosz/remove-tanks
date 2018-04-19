package remove.tanks.game.level.event.artillery;

import remove.tanks.game.level.event.EventCreateException;
import remove.tanks.game.level.event.SubEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class ArtilleryShootEventFactory implements SubEventFactory<ArtilleryShootEvent, ArtilleryShootEventPrefab> {
    @Override
    public ArtilleryShootEvent createEvent(ArtilleryShootEventPrefab prefab, ResourceRegistry registry) {
        try {
            return ArtilleryShootEvent.INSTANCE;
        } catch (Exception e) {
            throw new EventCreateException(prefab, e);
        }
    }

    @Override
    public Class<ArtilleryShootEventPrefab> getFactoryType() {
        return ArtilleryShootEventPrefab.class;
    }
}
