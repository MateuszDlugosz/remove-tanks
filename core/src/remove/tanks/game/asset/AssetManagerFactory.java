package remove.tanks.game.asset;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AssetLoader;

import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class AssetManagerFactory {
    private final Map<Class<?>, AssetLoader> assetLoaders;

    public AssetManagerFactory(Map<Class<?>, AssetLoader> assetLoaders) {
        this.assetLoaders = assetLoaders;
    }

    public AssetManager createAssetManager() {
        AssetManager assetManager = new AssetManager();
        assetLoaders.forEach(assetManager::setLoader);
        return assetManager;
    }
}
