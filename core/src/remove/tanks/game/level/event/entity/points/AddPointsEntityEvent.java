package remove.tanks.game.level.event.entity.points;

import com.badlogic.ashley.core.Entity;
import com.google.common.base.MoreObjects;
import remove.tanks.game.level.event.EntityEvent;

/**
 * @author Mateusz Długosz
 */
public final class AddPointsEntityEvent implements EntityEvent {
    private final Entity entity;
    private final int points;

    public AddPointsEntityEvent(Entity entity, int points) {
        this.entity = entity;
        this.points = points;
    }

    @Override
    public Entity getEntity() {
        return entity;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("points", points)
                .toString();
    }
}
