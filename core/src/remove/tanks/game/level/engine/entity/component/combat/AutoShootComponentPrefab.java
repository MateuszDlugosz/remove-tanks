package remove.tanks.game.level.engine.entity.component.combat;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;

/**
 * @author Mateusz Długosz
 */
public final class AutoShootComponentPrefab extends ComponentPrefab {
    public static final AutoShootComponentPrefab INSTANCE = new AutoShootComponentPrefab();

    private AutoShootComponentPrefab() {}

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
