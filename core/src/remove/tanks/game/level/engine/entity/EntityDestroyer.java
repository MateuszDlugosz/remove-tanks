package remove.tanks.game.level.engine.entity;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.physics.box2d.World;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

/**
 * @author Mateusz Długosz
 */
public final class EntityDestroyer {
    public void destroyEntity(Entity entity, ResourceRegistry registry) {
        PhysicsComponent physicsComponent = PhysicsComponent.MAPPER.get(entity);
        registry.getResource(ResourceType.EngineResource, Engine.class).removeEntity(entity);
        physicsComponent.getLightHandlers().forEach((k, v) -> v.getLight().remove());
        registry.getResource(ResourceType.WorldResource, World.class).destroyBody(physicsComponent.getBody());
    }
}
