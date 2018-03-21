package remove.tanks.game.level.engine.entity.component.combat;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;

/**
 * @author Mateusz Długosz
 */
public final class ProtectionComponentPrefab extends ComponentPrefab {
    public static final ProtectionComponentPrefab INSTANCE = new ProtectionComponentPrefab();

    private ProtectionComponentPrefab() {}

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
