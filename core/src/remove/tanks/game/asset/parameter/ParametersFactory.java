package remove.tanks.game.asset.parameter;

import com.badlogic.gdx.assets.AssetLoaderParameters;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
@SuppressWarnings("unchecked")
public final class ParametersFactory {
    private final Map<Class<? extends AssetLoaderParameters>, SubParametersFactory> factories
            = new HashMap<>();

    public ParametersFactory(SubParametersFactory[] factories) {
        Arrays.stream(factories).forEach(f -> this.factories.put(f.getFactoryType(), f));
    }

    public AssetLoaderParameters createAssetLoaderParameters(ParametersPrefab prefab) {
        try {
            if (!factories.containsKey(prefab.getClassName())) {
                throw new ParametersFactoryNotFoundException(prefab.getClassName());
            }
            return factories.get(prefab.getClassName()).createParameters(prefab);
        } catch (Exception e) {
            throw new ParametersCreateException(prefab, e);
        }
    }
}
