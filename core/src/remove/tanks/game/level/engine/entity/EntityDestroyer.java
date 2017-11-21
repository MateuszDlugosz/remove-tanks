package remove.tanks.game.level.engine.entity;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.physics.box2d.World;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;

/**
 * @author Mateusz Długosz
 */
public final class EntityDestroyer {
    public void destroyEntity(Entity entity, Level level) {
        PhysicsComponent physicsComponent = PhysicsComponent.MAPPER.get(entity);
        physicsComponent.getLightHandlers().forEach((k, v) -> v.getLight().remove());
        level.getResourceRegistry().getResource(LevelResource.Engine.toString(), Engine.class)
                .removeEntity(entity);
        level.getResourceRegistry()
                .getResource(LevelResource.World.toString(), World.class)
                .destroyBody(
                        physicsComponent.getBody()
                );
    }
}
