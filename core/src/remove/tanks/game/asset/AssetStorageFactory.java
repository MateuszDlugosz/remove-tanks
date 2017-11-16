package remove.tanks.game.asset;

import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import remove.tanks.game.asset.parameter.AssetIdDuplicateException;
import remove.tanks.game.asset.parameter.ParameterFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class AssetStorageFactory {
    private final ParameterFactory parameterFactory;

    public AssetStorageFactory(ParameterFactory parameterFactory) {
        this.parameterFactory = parameterFactory;
    }

    public AssetStorage createAssetStorage(List<AssetPrototype> prototypes) {
        AssetManager assetManager = new AssetManager();
        Map<String, String> idPathMap = new HashMap<>();
        try {
            prototypes.forEach(p -> {
                if (!assetManager.isLoaded(p.getFilename(), p.getClassName())) {
                    if (p.getParameterPrototype().isPresent()) {
                        loadAssetWithParameters(
                                assetManager,
                                p.getFilename(),
                                p.getClassName(),
                                parameterFactory.createAssetLoaderParameters(p.getParameterPrototype().get())
                        );
                    } else {
                        loadAssetWithoutParameters(assetManager, p.getFilename(), p.getClassName());
                    }
                    if (idPathMap.containsKey(p.getId())) {
                        throw new AssetIdDuplicateException(p.getId());
                    }
                    idPathMap.put(p.getId(), p.getFilename());
                }
            });
        } catch (Exception e) {
            throw new AssetStorageCreateException(e);
        }
        return new AssetStorage(assetManager, idPathMap);
    }

    private void loadAssetWithoutParameters(AssetManager assetManager, String filename, Class<?> className) {
        assetManager.load(filename, className);
        assetManager.finishLoading();
    }

    private void loadAssetWithParameters(AssetManager assetManager, String filename, Class<?> className, AssetLoaderParameters parameters) {
        assetManager.load(filename, className, parameters);
        assetManager.finishLoading();
    }
}
