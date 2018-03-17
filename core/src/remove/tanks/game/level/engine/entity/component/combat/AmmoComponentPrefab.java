package remove.tanks.game.level.engine.entity.component.combat;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;
import remove.tanks.game.level.utility.direction.Direction;

import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class AmmoComponentPrefab extends ComponentPrefab {
    private final int currentLevel;
    private final int maxLevel;
    private final Map<Integer, Map<Direction, String>> prefabCodes;

    public AmmoComponentPrefab(
            int currentLevel,
            int maxLevel,
            Map<Integer, Map<Direction, String>> prefabCodes
    ) {
        this.currentLevel = currentLevel;
        this.maxLevel = maxLevel;
        this.prefabCodes = prefabCodes;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public Map<Integer, Map<Direction, String>> getPrefabCodes() {
        return prefabCodes;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("currentLevel", currentLevel)
                .add("maxLevel", maxLevel)
                .add("prefabCodes", prefabCodes)
                .toString();
    }
}
