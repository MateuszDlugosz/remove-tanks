package remove.tanks.game.level.event.destroy;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.event.EventPrefab;

/**
 * @author Mateusz Długosz
 */
public final class DestroyFamilyEventPrefab extends EventPrefab {
    private final EntityFamily entityFamily;

    public DestroyFamilyEventPrefab(EntityFamily entityFamily) {
        this.entityFamily = entityFamily;
    }

    public EntityFamily getEntityFamily() {
        return entityFamily;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("entityFamily", entityFamily)
                .toString();
    }
}
