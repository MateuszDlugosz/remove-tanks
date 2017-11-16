package remove.tanks.game.level.engine.entity;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;
import remove.tanks.game.utility.position.Position;

/**
 * @author Mateusz Długosz
 */
public final class EntitySpawner {
    public void placeEntity(Entity entity, Position position) {
        PhysicsComponent pc = PhysicsComponent.MAPPER.get(entity);
        pc.getBody().setTransform(position.getX(), position.getY(), 0);
    }
}
