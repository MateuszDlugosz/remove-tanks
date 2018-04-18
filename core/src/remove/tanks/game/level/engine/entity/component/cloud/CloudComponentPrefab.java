package remove.tanks.game.level.engine.entity.component.cloud;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;

/**
 * @author Mateusz Długosz
 */
public final class CloudComponentPrefab extends ComponentPrefab {
    public static final CloudComponentPrefab INSTANCE = new CloudComponentPrefab();

    private CloudComponentPrefab() {}

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
