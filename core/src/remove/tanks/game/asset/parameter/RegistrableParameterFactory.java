package remove.tanks.game.asset.parameter;

import com.badlogic.gdx.assets.AssetLoaderParameters;

/**
 * @author Mateusz Długosz
 */
public interface RegistrableParameterFactory<T extends AssetLoaderParameters> {
    T createParameters(ParameterPrototype prototype);
    Class<T> getFactoryType();
}
