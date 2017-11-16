package remove.tanks.game.level.engine.entity.component.shoot;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrototype;
import remove.tanks.game.level.engine.utility.direction.Direction;

import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class AmmoComponentPrototype implements ComponentPrototype {
    private final int currentLevel;
    private final int maxLevel;
    private final Map<Integer, Map<Direction, String>> prototypeCodes;

    public AmmoComponentPrototype(
            int currentLevel,
            int maxLevel,
            Map<Integer, Map<Direction, String>> prototypeCodes
    ) {
        this.currentLevel = currentLevel;
        this.maxLevel = maxLevel;
        this.prototypeCodes = prototypeCodes;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public Map<Integer, Map<Direction, String>> getPrototypeCodes() {
        return prototypeCodes;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("currentLevel", currentLevel)
                .add("maxLevel", maxLevel)
                .add("prototypeCodes", prototypeCodes)
                .toString();
    }
}
