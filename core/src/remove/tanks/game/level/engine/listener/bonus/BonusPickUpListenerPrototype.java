package remove.tanks.game.level.engine.listener.bonus;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.listener.EntityListenerPrototype;

/**
 * @author Mateusz Długosz
 */
public final class BonusPickUpListenerPrototype extends EntityListenerPrototype {
    public BonusPickUpListenerPrototype(int priority) {
        super(priority);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
