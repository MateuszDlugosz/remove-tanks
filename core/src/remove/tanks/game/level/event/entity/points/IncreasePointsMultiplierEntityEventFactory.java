package remove.tanks.game.level.event.entity.points;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.event.EntityEventCreateException;
import remove.tanks.game.level.event.SubEntityEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class IncreasePointsMultiplierEntityEventFactory
        implements SubEntityEventFactory<IncreasePointsMultiplierEntityEvent, IncreasePointsMultiplierEntityEventPrefab>
{
    @Override
    public IncreasePointsMultiplierEntityEvent createEntityEvent(IncreasePointsMultiplierEntityEventPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new IncreasePointsMultiplierEntityEvent(entity);
        } catch (Exception e) {
            throw new EntityEventCreateException(prefab, e);
        }
    }

    @Override
    public Class<IncreasePointsMultiplierEntityEventPrefab> getFactoryType() {
        return IncreasePointsMultiplierEntityEventPrefab.class;
    }
}
