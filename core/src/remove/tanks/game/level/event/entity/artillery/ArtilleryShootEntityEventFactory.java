package remove.tanks.game.level.event.entity.artillery;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.event.EntityEventCreateException;
import remove.tanks.game.level.event.SubEntityEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class ArtilleryShootEntityEventFactory implements SubEntityEventFactory<ArtilleryShootEntityEvent, ArtilleryShootEntityEventPrefab> {
    @Override
    public ArtilleryShootEntityEvent createEntityEvent(ArtilleryShootEntityEventPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new ArtilleryShootEntityEvent(entity);
        } catch (Exception e) {
            throw new EntityEventCreateException(prefab, e);
        }
    }

    @Override
    public Class<ArtilleryShootEntityEventPrefab> getFactoryType() {
        return ArtilleryShootEntityEventPrefab.class;
    }
}
