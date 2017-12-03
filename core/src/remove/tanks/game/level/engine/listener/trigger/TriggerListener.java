package remove.tanks.game.level.engine.listener.trigger;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.listener.ExtendedEntityListener;

/**
 * @author Mateusz Długosz
 */
public final class TriggerListener extends ExtendedEntityListener {
    public TriggerListener(int priority, Engine engine) {
        super(priority, EntityFamily.TriggerFamily.getFamily(), engine);
    }

    @Override
    public void entityAdded(Entity entity) {}

    @Override
    public void entityRemoved(Entity entity) {

    }
}
