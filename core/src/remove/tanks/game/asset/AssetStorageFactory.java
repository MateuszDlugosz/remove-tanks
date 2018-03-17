package remove.tanks.game.asset;

import com.badlogic.gdx.assets.AssetManager;
import remove.tanks.game.asset.parameter.ParametersFactory;

/**
 * @author Mateusz Długosz
 */
public final class AssetStorageFactory {
    private final AssetManagerFactory assetManagerFactory;
    private final ParametersFactory parametersFactory;

    public AssetStorageFactory(AssetManagerFactory assetManagerFactory, ParametersFactory parametersFactory) {
        this.assetManagerFactory = assetManagerFactory;
        this.parametersFactory = parametersFactory;
    }

    public AssetStorage createAssetStorage(AssetPrefabRepository assetPrefabRepository) {
        try {
            return new AssetStorage(
                    createAssetManager(),
                    assetPrefabRepository,
                    parametersFactory
            );
        } catch (Exception e) {
            throw new AssetStorageCreateException(e);
        }
    }

    private AssetManager createAssetManager() {
        return assetManagerFactory.createAssetManager();
    }
}
