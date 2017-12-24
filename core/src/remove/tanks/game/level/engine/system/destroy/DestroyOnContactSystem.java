package remove.tanks.game.level.engine.system.destroy;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.systems.IteratingSystem;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.destroy.DestroyComponent;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;

/**
 * @author Mateusz Długosz
 */
public final class DestroyOnContactSystem extends IteratingSystem {
    public DestroyOnContactSystem(int priority) {
        super(EntityFamily.DestroyOnContactFamily.getFamily(), priority);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        PhysicsComponent pc = PhysicsComponent.MAPPER.get(entity);
        pc.getSensors().values().forEach(s -> {
            if (s.isContacted()) {
                entity.add(new DestroyComponent());
            }
        });
    }
}
