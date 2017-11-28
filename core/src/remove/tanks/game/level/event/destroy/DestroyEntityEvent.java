package remove.tanks.game.level.event.destroy;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.event.Event;

/**
 * @author Mateusz Długosz
 */
public final class DestroyEntityEvent implements Event {
    private final Entity entity;

    public DestroyEntityEvent(Entity entity) {
        this.entity = entity;
    }

    public Entity getEntity() {
        return entity;
    }
}
