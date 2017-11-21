package remove.tanks.game.level.event.destroy;

import com.badlogic.ashley.core.Entity;

/**
 * @author Mateusz Długosz
 */
public final class DestroyEntityEvent {
    private final Entity entity;

    public DestroyEntityEvent(Entity entity) {
        this.entity = entity;
    }

    public Entity getEntity() {
        return entity;
    }
}
