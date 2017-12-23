package remove.tanks.game.asset.parameter;

import com.badlogic.gdx.assets.AssetLoaderParameters;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
@SuppressWarnings("unchecked")
public final class ParametersFactory {
    private final Map<Class<? extends AssetLoaderParameters>, RegistrableParametersFactory> factories
            = new HashMap<>();

    public void registerFactory(RegistrableParametersFactory factory) {
        factories.put(factory.getFactoryType(), factory);
    }

    public AssetLoaderParameters createAssetLoaderParameters(ParametersPrototype prototype) {
        try {
            if (!factories.containsKey(prototype.getClassName())) {
                throw new ParametersFactoryNotFoundException(prototype.getClassName());
            }
            return factories.get(prototype.getClassName()).createParameters(prototype);
        } catch (Exception e) {
            throw new ParametersCreateException(prototype, e);
        }
    }
}
