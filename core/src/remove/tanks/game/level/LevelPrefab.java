package remove.tanks.game.level;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.EnginePrefab;
import remove.tanks.game.level.preload.PreloadData;
import remove.tanks.game.level.resource.configuration.ResourceConfigurations;
import remove.tanks.game.utility.Prefab;

/**
 * @author Mateusz Długosz
 */
public final class LevelPrefab extends Prefab {
    private final PreloadData preloadData;
    private final ResourceConfigurations resourceConfigurations;
    private final String tiledMapFilename;
    private final String entityPrefabRepositoryFilename;
    private final String assetPrefabRepositoryFilename;
    private final EnginePrefab enginePrefab;

    public LevelPrefab(
            PreloadData preloadData,
            ResourceConfigurations resourceConfigurations,
            String tiledMapFilename,
            String entityPrefabRepositoryFilename,
            String assetPrefabRepositoryFilename,
            EnginePrefab enginePrefab
    ) {
        this.preloadData = preloadData;
        this.resourceConfigurations = resourceConfigurations;
        this.tiledMapFilename = tiledMapFilename;
        this.entityPrefabRepositoryFilename = entityPrefabRepositoryFilename;
        this.assetPrefabRepositoryFilename = assetPrefabRepositoryFilename;
        this.enginePrefab = enginePrefab;
    }

    public PreloadData getPreloadData() {
        return preloadData;
    }

    public ResourceConfigurations getResourceConfigurations() {
        return resourceConfigurations;
    }

    public String getTiledMapFilename() {
        return tiledMapFilename;
    }

    public String getEntityPrefabRepositoryFilename() {
        return entityPrefabRepositoryFilename;
    }

    public String getAssetPrefabRepositoryFilename() {
        return assetPrefabRepositoryFilename;
    }

    public EnginePrefab getEnginePrefab() {
        return enginePrefab;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("preloadData", preloadData)
                .add("resourceConfigurations", resourceConfigurations)
                .add("tiledMapFilename", tiledMapFilename)
                .add("entityPrefabRepositoryFilename", entityPrefabRepositoryFilename)
                .add("assetPrefabRepositoryFilename", assetPrefabRepositoryFilename)
                .add("enginePrefab", enginePrefab)
                .toString();
    }
}
