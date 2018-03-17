package remove.tanks.game.asset;

import com.google.common.base.MoreObjects;
import remove.tanks.game.asset.parameter.ParametersPrefab;
import remove.tanks.game.utility.Prefab;

import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public final class AssetPrefab extends Prefab {
    private final String id;
    private final String filename;
    private final Class<?> assetClass;
    private final ParametersPrefab parametersPrefab;

    public AssetPrefab(String id, String filename, Class<?> assetClass, ParametersPrefab parametersPrefab) {
        this.id = id;
        this.filename = filename;
        this.assetClass = assetClass;
        this.parametersPrefab = parametersPrefab;
    }

    public String getId() {
        return id;
    }

    public String getFilename() {
        return filename;
    }

    public Class<?> getAssetClass() {
        return assetClass;
    }

    public Optional<ParametersPrefab> getParametersPrefab() {
        return Optional.ofNullable(parametersPrefab);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("filename", filename)
                .add("assetClass", assetClass)
                .add("parametersPrefab", parametersPrefab)
                .toString();
    }
}
