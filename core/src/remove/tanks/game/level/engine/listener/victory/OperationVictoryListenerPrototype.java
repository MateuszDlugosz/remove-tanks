package remove.tanks.game.level.engine.listener.victory;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.listener.EntityListenerPrototype;

/**
 * @author Mateusz Długosz
 */
public final class OperationVictoryListenerPrototype extends EntityListenerPrototype {
    public OperationVictoryListenerPrototype(int priority) {
        super(priority);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
