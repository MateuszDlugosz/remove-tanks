package remove.tanks.game.level.engine.system.health;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.systems.IteratingSystem;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.destroy.DestroyComponent;
import remove.tanks.game.level.engine.entity.component.health.HealthComponent;

/**
 * @author Mateusz Długosz
 */
public final class HealthSystem extends IteratingSystem {
    public HealthSystem(int priority) {
        super(EntityFamily.HealthFamily.getFamily(), priority);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        if (HealthComponent.MAPPER.get(entity).getHealth() <= 0)
            entity.add(new DestroyComponent());
    }
}
