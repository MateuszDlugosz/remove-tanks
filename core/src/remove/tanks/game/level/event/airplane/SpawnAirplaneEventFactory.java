package remove.tanks.game.level.event.airplane;

import remove.tanks.game.level.event.EventCreateException;
import remove.tanks.game.level.event.SubEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class SpawnAirplaneEventFactory implements SubEventFactory<SpawnAirplaneEvent, SpawnAirplaneEventPrefab> {
    @Override
    public SpawnAirplaneEvent createEvent(SpawnAirplaneEventPrefab prefab, ResourceRegistry registry) {
        try {
            return SpawnAirplaneEvent.INSTANCE;
        } catch (Exception e) {
            throw new EventCreateException(prefab, e);
        }
    }

    @Override
    public Class<SpawnAirplaneEventPrefab> getFactoryType() {
        return SpawnAirplaneEventPrefab.class;
    }
}
