package remove.tanks.game.level.event.entity.destroy;

import com.badlogic.ashley.core.Entity;
import com.google.common.base.MoreObjects;
import remove.tanks.game.level.event.EntityEvent;

/**
 * @author Mateusz Długosz
 */
public final class DestroyEntityByIdEntityEvent implements EntityEvent {
    private final Entity entity;
    private final String id;

    public DestroyEntityByIdEntityEvent(Entity entity, String id) {
        this.entity = entity;
        this.id = id;
    }

    @Override
    public Entity getEntity() {
        return entity;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("entity", entity)
                .add("id", id)
                .toString();
    }
}
