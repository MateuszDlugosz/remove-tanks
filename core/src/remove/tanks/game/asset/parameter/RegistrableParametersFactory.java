package remove.tanks.game.asset.parameter;

import com.badlogic.gdx.assets.AssetLoaderParameters;

/**
 * @author Mateusz Długosz
 */
public interface RegistrableParametersFactory<T extends AssetLoaderParameters> {
    T createParameters(ParametersPrototype prototype);
    Class<T> getFactoryType();
}
