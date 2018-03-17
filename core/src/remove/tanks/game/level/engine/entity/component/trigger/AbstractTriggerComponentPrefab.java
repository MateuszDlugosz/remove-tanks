package remove.tanks.game.level.engine.entity.component.trigger;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;
import remove.tanks.game.level.event.EntityEventPrefab;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public abstract class AbstractTriggerComponentPrefab extends ComponentPrefab {
    private final List<EntityEventPrefab> entityEventPrefabs;

    public AbstractTriggerComponentPrefab(List<EntityEventPrefab> entityEventPrefabs) {
        this.entityEventPrefabs = entityEventPrefabs;
    }

    public List<EntityEventPrefab> getEntityEventPrefabs() {
        return entityEventPrefabs;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("entityEventPrefabs", entityEventPrefabs)
                .toString();
    }
}
