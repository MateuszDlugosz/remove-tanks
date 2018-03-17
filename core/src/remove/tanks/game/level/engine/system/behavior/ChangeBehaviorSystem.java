package remove.tanks.game.level.engine.system.behavior;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.systems.IteratingSystem;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.behavior.ChangeBehaviorComponent;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;

/**
 * @author Mateusz Długosz
 */
public final class ChangeBehaviorSystem extends IteratingSystem {
    public ChangeBehaviorSystem(int priority) {
        super(EntityFamily.ChangeBehaviorFamily.getFamily(), priority);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        PhysicsComponent.MAPPER.get(entity).getSensors().values().forEach(s -> {
            if (s.isContacted()) {
                s.getContacts().forEach(e -> ChangeBehaviorComponent.MAPPER.get(entity)
                        .getComponents().forEach(((Entity) e)::add));
            }
        });
    }
}
