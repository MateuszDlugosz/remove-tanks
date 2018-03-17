package remove.tanks.game.asset;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.utils.Disposable;
import remove.tanks.game.asset.parameter.ParametersFactory;

import java.util.Arrays;
import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class AssetStorage implements Disposable {
    private final AssetManager assetManager;
    private final AssetPrefabRepository assetPrefabRepository;
    private final ParametersFactory parametersFactory;

    AssetStorage(AssetManager assetManager, AssetPrefabRepository assetPrefabRepository, ParametersFactory parametersFactory) {
        this.assetManager = assetManager;
        this.assetPrefabRepository = assetPrefabRepository;
        this.parametersFactory = parametersFactory;
    }

    public void loadAssets(String[] ids) {
        loadAssets(Arrays.asList(ids));
    }

    public void loadAssets(List<String> ids) {
        ids.forEach(this::loadAsset);
    }

    public void loadAsset(String id) {
        try {
             if (!isAssetLoaded(id)) {
                 if (assetPrefabRepository.getAssetPrefab(id).getParametersPrefab().isPresent()) {
                     loadAssetWithParameters(id);
                 } else {
                     loadAssetWithoutParameters(id);
                 }
             }
        } catch (Exception e) {
            throw new AssetLoadException(id, e);
        }
    }

    @SuppressWarnings("unchecked")
    private void loadAssetWithParameters(String id) {
        try {
            assetManager.load(
                    assetPrefabRepository.getAssetPrefab(id).getFilename(),
                    assetPrefabRepository.getAssetPrefab(id).getAssetClass(),
                    parametersFactory.createAssetLoaderParameters(
                            assetPrefabRepository.getAssetPrefab(id).getParametersPrefab().get()
                    )
            );
            assetManager.finishLoading();
        } catch (Exception e) {
            throw new AssetLoadException(id, e);
        }
    }

    private void loadAssetWithoutParameters(String id) {
        try {
            assetManager.load(
                    assetPrefabRepository.getAssetPrefab(id).getFilename(),
                    assetPrefabRepository.getAssetPrefab(id).getAssetClass()
            );
            assetManager.finishLoading();
        } catch (Exception e) {
            throw new AssetLoadException(id, e);
        }
    }

    public void unloadAssets(String[] ids) {
        unloadAssets(Arrays.asList(ids));
    }

    public void unloadAssets(List<String> ids) {
        ids.forEach(this::unloadAsset);
    }

    public void unloadAsset(String id) {
        try {
            assetManager.unload(assetPrefabRepository.getAssetPrefab(id).getFilename());
        } catch (Exception e) {
            throw new UnloadAssetException(id, e);
        }
    }

    public void unloadAllAssets() {
        assetManager.dispose();
    }

    public <T> T getAsset(String id, Class<T> assetClass) {
        if (!assetPrefabRepository.getAssetPrefab(id).getAssetClass().equals(assetClass)) {
            throw new AssetIncompatibleClassException(assetPrefabRepository.getAssetPrefab(id).getAssetClass(), assetClass);
        }
        return assetManager.get(assetPrefabRepository.getAssetPrefab(id).getFilename(), assetClass);
    }

    public boolean isAssetLoaded(String id) {
        return assetManager.isLoaded(assetPrefabRepository.getAssetPrefab(id).getFilename());
    }

    @Override
    public void dispose() {
        assetManager.dispose();
    }
}
