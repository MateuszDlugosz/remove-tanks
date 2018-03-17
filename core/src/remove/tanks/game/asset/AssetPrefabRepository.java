package remove.tanks.game.asset;

import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class AssetPrefabRepository {
    private Map<String, AssetPrefab> assetPrefabs;

    public AssetPrefabRepository(Map<String, AssetPrefab> assetPrefabs) {
        this.assetPrefabs = assetPrefabs;
    }

    public AssetPrefab getAssetPrefab(String id) {
        if (!assetPrefabs.containsKey(id)) {
            throw new AssetPrefabNotFoundException(id);
        }
        return assetPrefabs.get(id);
    }
}
