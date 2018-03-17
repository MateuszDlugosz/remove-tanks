package remove.tanks.game.level.engine.system.lifecycle;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.system.EntitySystemPrefab;

public final class DestroyOnContactSystemPrefab extends EntitySystemPrefab {
    public DestroyOnContactSystemPrefab(int priority) {
        super(priority);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
