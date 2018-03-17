package remove.tanks.game.level.event.entity.state;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.event.EntityEventCreateException;
import remove.tanks.game.level.event.SubEntityEventFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class ChangeLevelStateEntityEventFactory implements SubEntityEventFactory<ChangeLevelStateEntityEvent, ChangeLevelStateEntityEventPrefab> {
    @Override
    public ChangeLevelStateEntityEvent createEntityEvent(ChangeLevelStateEntityEventPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            return new ChangeLevelStateEntityEvent(entity, prefab.getLevelState());
        } catch (Exception e) {
            throw new EntityEventCreateException(prefab, e);
        }
    }

    @Override
    public Class<ChangeLevelStateEntityEventPrefab> getFactoryType() {
        return ChangeLevelStateEntityEventPrefab.class;
    }
}
