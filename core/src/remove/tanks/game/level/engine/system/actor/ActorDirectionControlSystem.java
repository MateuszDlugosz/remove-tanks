package remove.tanks.game.level.engine.system.actor;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.actor.ActorComponent;
import remove.tanks.game.level.engine.entity.component.actor.ActorDirectionControllerComponent;
import remove.tanks.game.level.engine.entity.component.direction.DirectionComponent;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;

/**
 * @author Mateusz Długosz
 */
public final class ActorDirectionControlSystem extends EntitySystem {
    public ActorDirectionControlSystem(int priority) {
        super(priority);
    }

    @Override
    public void update(float deltaTime) {
        getEngine().getEntitiesFor(EntityFamily.ActorDirectionControllerFamily.getFamily()).forEach(c -> {
            PhysicsComponent.MAPPER.get(c).getSensors().values().forEach(s -> {
                if (s.isContacted()) {
                    s.getContacts().forEach(e -> {
                        if (((Entity) e).getComponent(ActorComponent.class) != null && ((Entity) e).getComponent(DirectionComponent.class) != null) {
                            ((Entity) e).add(new DirectionComponent(ActorDirectionControllerComponent.MAPPER.get(c).getNewDirection()));
                        }
                    });
                }
            });
        });
    }
}
