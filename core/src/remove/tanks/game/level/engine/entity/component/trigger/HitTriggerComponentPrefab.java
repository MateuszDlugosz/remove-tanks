package remove.tanks.game.level.engine.entity.component.trigger;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.event.EntityEventPrefab;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class HitTriggerComponentPrefab extends AbstractTriggerComponentPrefab {
    public HitTriggerComponentPrefab(List<EntityEventPrefab> entityEventPrefabs) {
        super(entityEventPrefabs);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
