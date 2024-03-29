package remove.tanks.game.level.engine.entity.component.lifecycle;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;

public final class DestroyOnContactComponentPrefab extends ComponentPrefab {
    public static final DestroyOnContactComponentPrefab INSTANCE = new DestroyOnContactComponentPrefab();

    private DestroyOnContactComponentPrefab() {}

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
