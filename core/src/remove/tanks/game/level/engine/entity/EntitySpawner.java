package remove.tanks.game.level.engine.entity;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;
import remove.tanks.game.utility.position.Position;

/**
 * @author Mateusz Długosz
 */
public final class EntitySpawner {
    public void spawnEntity(Entity entity, Position position, Level level) {
        PhysicsComponent pc = PhysicsComponent.MAPPER.get(entity);
        pc.getBody().setTransform(position.getX(), position.getY(), 0);
        level.getResourceRegistry().getResource(LevelResource.Engine.toString(), Engine.class)
                .addEntity(entity);
    }
}
