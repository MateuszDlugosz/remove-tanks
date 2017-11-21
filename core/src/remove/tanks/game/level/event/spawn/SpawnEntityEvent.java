package remove.tanks.game.level.event.spawn;

import remove.tanks.game.level.engine.entity.EntityPrototype;
import remove.tanks.game.utility.position.Position;

/**
 * @author Mateusz Długosz
 */
public final class SpawnEntityEvent {
    private final EntityPrototype entityPrototype;
    private final Position position;

    public SpawnEntityEvent(EntityPrototype entityPrototype, Position position) {
        this.entityPrototype = entityPrototype;
        this.position = position;
    }

    public EntityPrototype getEntityPrototype() {
        return entityPrototype;
    }

    public Position getPosition() {
        return position;
    }
}
