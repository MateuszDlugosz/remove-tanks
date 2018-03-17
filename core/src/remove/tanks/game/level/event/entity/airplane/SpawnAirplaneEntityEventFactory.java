package remove.tanks.game.level.event.entity.airplane;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.event.EntityEventCreateException;
import remove.tanks.game.level.event.SubEntityEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class SpawnAirplaneEntityEventFactory implements SubEntityEventFactory<SpawnAirplaneEntityEvent, SpawnAirplaneEntityEventPrefab> {
    @Override
    public SpawnAirplaneEntityEvent createEntityEvent(SpawnAirplaneEntityEventPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new SpawnAirplaneEntityEvent(entity);
        } catch (Exception e) {
            throw new EntityEventCreateException(prefab, e);
        }
    }

    @Override
    public Class<SpawnAirplaneEntityEventPrefab> getFactoryType() {
        return SpawnAirplaneEntityEventPrefab.class;
    }
}
