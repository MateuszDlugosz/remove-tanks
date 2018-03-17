package remove.tanks.game.level.event.entity.destroy;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.event.EntityEventPrefab;

/**
 * @author Mateusz Długosz
 */
public final class DestroyFamilyEntityEventPrefab extends EntityEventPrefab {
    private final EntityFamily entityFamily;

    public DestroyFamilyEntityEventPrefab(EntityFamily entityFamily) {
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
