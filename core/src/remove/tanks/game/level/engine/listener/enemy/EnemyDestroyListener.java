package remove.tanks.game.level.engine.listener.enemy;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.listener.ExtendedEntityListener;
import remove.tanks.game.level.event.enemy.DecreaseEnemiesCounterEvent;

/**
 * @author Mateusz Długosz
 */
public final class EnemyDestroyListener extends ExtendedEntityListener {
    private final EventBus eventBus;

    public EnemyDestroyListener(int priority, Engine engine, EventBus eventBus) {
        super(priority, EntityFamily.EnemiesFamily.getFamily(), engine);
        this.eventBus = eventBus;
    }

    @Override
    public void entityAdded(Entity entity) {}

    @Override
    public void entityRemoved(Entity entity) {
        eventBus.post(new DecreaseEnemiesCounterEvent());
    }
}
