package remove.tanks.game.level.event.entity.points;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.event.EntityEventCreateException;
import remove.tanks.game.level.event.SubEntityEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class ResetPointsMultiplierEntityEventFactory implements SubEntityEventFactory<ResetPointsMultiplierEntityEvent, ResetPointsMultiplierEntityEventPrefab> {
    @Override
    public ResetPointsMultiplierEntityEvent createEntityEvent(ResetPointsMultiplierEntityEventPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new ResetPointsMultiplierEntityEvent(entity);
        } catch (Exception e) {
            throw new EntityEventCreateException(prefab, e);
        }
    }

    @Override
    public Class<ResetPointsMultiplierEntityEventPrefab> getFactoryType() {
        return ResetPointsMultiplierEntityEventPrefab.class;
    }
}
