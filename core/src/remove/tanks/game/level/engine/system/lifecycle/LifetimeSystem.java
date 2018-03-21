package remove.tanks.game.level.engine.system.lifecycle;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.systems.IteratingSystem;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.lifecycle.DestroyComponent;
import remove.tanks.game.level.engine.entity.component.lifecycle.LifetimeComponent;

/**
 * @author Mateusz Długosz
 */
public final class LifetimeSystem extends IteratingSystem {
    public LifetimeSystem(int priority) {
        super(EntityFamily.LifetimeFamily.getFamily(), priority);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        if (!LifetimeComponent.MAPPER.get(entity).getTimer().isCompleted()) {
            LifetimeComponent.MAPPER.get(entity).getTimer().update(deltaTime);
        } else {
            entity.add(DestroyComponent.INSTANCE);
        }
    }
}
