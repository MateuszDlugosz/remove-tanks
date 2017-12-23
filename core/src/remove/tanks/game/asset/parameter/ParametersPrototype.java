package remove.tanks.game.asset.parameter;

import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class ParametersPrototype implements Serializable {
    private final Class<? extends AssetLoaderParameters> className;
    private final Map<String, String> parameters;

    public ParametersPrototype(
            Class<? extends AssetLoaderParameters> className,
            Map<String, String> parameters
    ) {
        this.className = className;
        this.parameters = parameters;
    }

    public Class<? extends AssetLoaderParameters> getClassName() {
        return className;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("className", className)
                .add("parameters", parameters)
                .toString();
    }
}
