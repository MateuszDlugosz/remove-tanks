package remove.tanks.game.level.engine.listener.bonus;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.listener.EntityListenerPrefab;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class LeaveBonusListenerPrefab extends EntityListenerPrefab {
    private final List<String> prefabCodes;
    private final float chance;

    public LeaveBonusListenerPrefab(int priority, List<String> prefabCodes, float chance) {
        super(priority);
        this.prefabCodes = prefabCodes;
        this.chance = chance;
    }

    public List<String> getPrefabCodes() {
        return prefabCodes;
    }

    public float getChance() {
        return chance;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("prefabCodes", prefabCodes)
                .add("chance", chance)
                .toString();
    }
}
