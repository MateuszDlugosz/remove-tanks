package remove.tanks.game.level.resource.factories;

import com.badlogic.gdx.Gdx;
import remove.tanks.game.asset.AssetPrefabRepositoryXmlReader;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.asset.AssetStorageFactory;
import remove.tanks.game.level.LevelPrefab;
import remove.tanks.game.level.engine.entity.EntityPrefabStorage;
import remove.tanks.game.level.resource.AbstractLocalResourceFactory;
import remove.tanks.game.level.resource.ResourceDisposer;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

import java.util.EnumMap;
import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class AssetStorageLocalResourceFactory extends AbstractLocalResourceFactory<AssetStorage> {
    private final AssetPrefabRepositoryXmlReader assetPrefabRepositoryXmlReader;
    private final AssetStorageFactory assetStorageFactory;

    public AssetStorageLocalResourceFactory(
            AssetPrefabRepositoryXmlReader assetPrefabRepositoryXmlReader,
            AssetStorageFactory assetStorageFactory
    ) {
        this.assetPrefabRepositoryXmlReader = assetPrefabRepositoryXmlReader;
        this.assetStorageFactory = assetStorageFactory;
    }

    @Override
    protected AssetStorage createResourceObject(EnumMap<ResourceType, Object> globalObjects, ResourceRegistry registry) {
        AssetStorage assetStorage = assetStorageFactory.createAssetStorage(
                assetPrefabRepositoryXmlReader.readAssetPrefabRepository(Gdx.files.internal(
                        registry.getResource(ResourceType.LevelPrefabResource, LevelPrefab.class)
                                .getAssetPrefabRepositoryFilename()))
        );
        loadAssets(assetStorage, registry.getResource(ResourceType.LevelPrefabResource,
                LevelPrefab.class).getPreloadData().getAssetIds());
        EntityPrefabStorage entityPrefabStorage = registry.getResource(ResourceType.EntityPrefabStorageResource,
                EntityPrefabStorage.class);
        entityPrefabStorage.getEntityPrefabCodes().forEach(code -> loadAssets(assetStorage,
                entityPrefabStorage.getEntityPrefab(code).getPreloadData().getAssetIds()));
        return assetStorage;
    }

    private void loadAssets(AssetStorage assetStorage, List<String> assetIds) {
        assetIds.forEach(assetStorage::loadAsset);
    }

    @Override
    protected ResourceDisposer<AssetStorage> createResourceDisposer() {
        return AssetStorage::unloadAllAssets;
    }

    @Override
    protected ResourceType getCreatedResourceType() {
        return ResourceType.AssetStorageResource;
    }

    @Override
    protected ResourceType[] getRequiredResources() {
        return new ResourceType[] {
                ResourceType.LevelPrefabResource
        };
    }
}
