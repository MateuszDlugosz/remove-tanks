package remove.tanks.game.level.event.points;

import remove.tanks.game.level.event.EventCreateException;
import remove.tanks.game.level.event.SubEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class ResetPointsMultiplierEventFactory implements SubEventFactory<ResetPointsMultiplierEvent, ResetPointsMultiplierEventPrefab> {
    @Override
    public ResetPointsMultiplierEvent createEvent(ResetPointsMultiplierEventPrefab prefab, ResourceRegistry registry) {
        try {
            return ResetPointsMultiplierEvent.INSTANCE;
        } catch (Exception e) {
            throw new EventCreateException(prefab, e);
        }
    }

    @Override
    public Class<ResetPointsMultiplierEventPrefab> getFactoryType() {
        return ResetPointsMultiplierEventPrefab.class;
    }
}
