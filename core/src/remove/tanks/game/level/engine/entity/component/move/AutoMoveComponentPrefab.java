package remove.tanks.game.level.engine.entity.component.move;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;

/**
 * @author Mateusz Długosz
 */
public final class AutoMoveComponentPrefab extends ComponentPrefab {
    public static final AutoMoveComponentPrefab INSTANCE = new AutoMoveComponentPrefab();

    private AutoMoveComponentPrefab() {}

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
