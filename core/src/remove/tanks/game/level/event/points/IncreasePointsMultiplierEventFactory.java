package remove.tanks.game.level.event.points;

import remove.tanks.game.level.event.EventCreateException;
import remove.tanks.game.level.event.SubEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class IncreasePointsMultiplierEventFactory implements SubEventFactory<IncreasePointsMultiplierEvent, IncreasePointsMultiplierEventPrefab> {
    @Override
    public IncreasePointsMultiplierEvent createEvent(IncreasePointsMultiplierEventPrefab prefab, ResourceRegistry registry) {
        try {
            return new IncreasePointsMultiplierEvent();
        } catch (Exception e) {
            throw new EventCreateException(prefab, e);
        }
    }

    @Override
    public Class<IncreasePointsMultiplierEventPrefab> getFactoryType() {
        return IncreasePointsMultiplierEventPrefab.class;
    }
}
