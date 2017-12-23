package remove.tanks.game.asset;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.utils.Disposable;

import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class AssetStorage implements Disposable {
    private final AssetManager assetManager;
    private final Map<String, String> idPathMap;

    AssetStorage(
            AssetManager assetManager,
            Map<String, String> idPathMap
    ) {
        this.assetManager = assetManager;
        this.idPathMap = idPathMap;
    }

    public <T> T getAsset(String id, Class<T> className) {
        if (!idPathMap.containsKey(id)) {
            throw new AssetIdNotExistsException(id);
        }
        return assetManager.get(idPathMap.get(id), className);
    }

    @Override
    public void dispose() {
        assetManager.dispose();
    }
}
