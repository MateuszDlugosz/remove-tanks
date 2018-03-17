package remove.tanks.game.level.engine.entity;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.utility.surface.position.Position;

/**
 * @author Mateusz Długosz
 */
public final class EntityPlacer {
    public void placeEntity(Entity entity, Position position, ResourceRegistry registry) {
        PhysicsComponent pc = PhysicsComponent.MAPPER.get(entity);
        pc.getBody().setTransform(position.getX(), position.getY(), pc.getBody().getAngle());
        registry.getResource(ResourceType.EngineResource, Engine.class).addEntity(entity);
    }
}
