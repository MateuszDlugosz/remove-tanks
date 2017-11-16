package remove.tanks.game.level.engine.listener.enemy;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.listener.EntityListenerPrototype;

/**
 * @author Mateusz Długosz
 */
public final class EnemyDestroyListenerPrototype extends EntityListenerPrototype {
    public EnemyDestroyListenerPrototype(int priority) {
        super(priority);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
