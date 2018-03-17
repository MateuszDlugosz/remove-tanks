package remove.tanks.game.level.preload;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class PreloadData {
    private final List<String> entityPrefabCodes;
    private final List<String> assetIds;

    public PreloadData(List<String> entityPrefabCodes, List<String> assetIds) {
        this.entityPrefabCodes = entityPrefabCodes;
        this.assetIds = assetIds;
    }

    public List<String> getEntityPrefabCodes() {
        return entityPrefabCodes;
    }

    public List<String> getAssetIds() {
        return assetIds;
    }
}
