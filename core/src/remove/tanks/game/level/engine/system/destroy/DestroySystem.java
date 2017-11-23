package remove.tanks.game.level.engine.system.destroy;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.systems.IteratingSystem;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.event.destroy.DestroyEntityEvent;

/**
 * @author Mateusz Długosz
 */
public final class DestroySystem extends IteratingSystem {
    private final EventBus eventBus;

    public DestroySystem(int priority, EventBus eventBus) {
        super(EntityFamily.DestroyedFamily.getFamily(), priority);
        this.eventBus = eventBus;
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        eventBus.post(new DestroyEntityEvent(entity));
    }
}
