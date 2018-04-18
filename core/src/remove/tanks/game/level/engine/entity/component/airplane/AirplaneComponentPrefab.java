package remove.tanks.game.level.engine.entity.component.airplane;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;

/**
 * @author Mateusz Długosz
 */
public final class AirplaneComponentPrefab extends ComponentPrefab {
    public static final AirplaneComponentPrefab INSTANCE = new AirplaneComponentPrefab();

    private AirplaneComponentPrefab() {}

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
}
