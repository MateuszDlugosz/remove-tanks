package remove.tanks.game.level.engine.entity.component.lifecycle;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;

/**
 * @author Mateusz Długosz
 */
public final class DestroyComponentPrefab extends ComponentPrefab {
    public static final DestroyComponentPrefab INSTANCE = new DestroyComponentPrefab();

    private DestroyComponentPrefab() {}

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
