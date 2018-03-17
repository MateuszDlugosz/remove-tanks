package remove.tanks.game.asset.parameter;

import com.badlogic.gdx.assets.AssetLoaderParameters;

/**
 * @author Mateusz Długosz
 */
public interface SubParametersFactory<T extends AssetLoaderParameters> {
    T createParameters(ParametersPrefab prefab);
    Class<T> getFactoryType();
}
