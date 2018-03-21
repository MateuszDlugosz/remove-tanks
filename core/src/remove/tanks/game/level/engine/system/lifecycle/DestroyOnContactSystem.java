package remove.tanks.game.level.engine.system.lifecycle;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.systems.IteratingSystem;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.lifecycle.DestroyComponent;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;

public final class DestroyOnContactSystem extends IteratingSystem {
    public DestroyOnContactSystem(int priority) {
        super(EntityFamily.DestroyOnContactFamily.getFamily(), priority);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        PhysicsComponent.MAPPER.get(entity).getSensors().values().forEach(s -> {
            if (s.isContacted()) entity.add(DestroyComponent.INSTANCE);
        });
    }
}
