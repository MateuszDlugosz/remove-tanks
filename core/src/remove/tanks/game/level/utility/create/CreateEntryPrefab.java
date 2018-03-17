package remove.tanks.game.level.utility.create;

import com.google.common.base.MoreObjects;
import remove.tanks.game.utility.Prefab;
import remove.tanks.game.utility.surface.position.PositionPrefab;

/**
 * @author Mateusz Długosz
 */
public final class CreateEntryPrefab extends Prefab {
    private final String prefabCode;
    private final PositionPrefab positionPrefab;

    public CreateEntryPrefab(String prefabCode, PositionPrefab positionPrefab) {
        this.prefabCode = prefabCode;
        this.positionPrefab = positionPrefab;
    }

    public String getPrefabCode() {
        return prefabCode;
    }

    public PositionPrefab getPositionPrefab() {
        return positionPrefab;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("prefabCode", prefabCode)
                .add("positionPrefab", positionPrefab)
                .toString();
    }
}
