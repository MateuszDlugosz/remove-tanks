package remove.tanks.game.asset.parameter;

import com.badlogic.gdx.assets.AssetLoaderParameters;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class ParameterFactory {
    private final Map<Class<? extends AssetLoaderParameters>, RegistrableParameterFactory> subFactories
            = new HashMap<>();

    public ParameterFactory(RegistrableParameterFactory[] subFactories) {
        Arrays.stream(subFactories).forEach(s -> this.subFactories.put(s.getFactoryType(), s));
    }

    public AssetLoaderParameters createAssetLoaderParameters(ParameterPrototype prototype) {
        if (!subFactories.containsKey(prototype.getClassName())) {
            throw new ParameterFactoryNotFoundException(prototype.getClassName());
        }
        return subFactories.get(prototype.getClassName()).createParameters(prototype);
    }
}
