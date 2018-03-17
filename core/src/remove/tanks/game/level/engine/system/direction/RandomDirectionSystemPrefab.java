package remove.tanks.game.level.engine.system.direction;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.system.EntitySystemPrefab;

/**
 * @author Mateusz Długosz
 */
public final class RandomDirectionSystemPrefab extends EntitySystemPrefab {
    public RandomDirectionSystemPrefab(int priority) {
        super(priority);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
