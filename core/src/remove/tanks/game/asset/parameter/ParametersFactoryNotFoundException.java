package remove.tanks.game.asset.parameter;

import com.badlogic.gdx.assets.AssetLoaderParameters;

/**
 * @author Mateusz Długosz
 */
public final class ParametersFactoryNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Asset loader parameters factory of %s not found.";

    public ParametersFactoryNotFoundException(Class<? extends AssetLoaderParameters> className) {
        super(String.format(MESSAGE_TEMPLATE, className));
    }
}
