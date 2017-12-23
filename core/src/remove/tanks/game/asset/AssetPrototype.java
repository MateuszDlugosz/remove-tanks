package remove.tanks.game.asset;

import com.google.common.base.MoreObjects;
import remove.tanks.game.asset.parameter.ParametersPrototype;

import java.io.Serializable;
import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public final class AssetPrototype implements Serializable {
    private final String id;
    private final Class<?> className;
    private final String filename;
    private final ParametersPrototype parametersPrototype;

    public AssetPrototype(
            String id,
            Class<?> className,
            String filename,
            ParametersPrototype parametersPrototype
    ) {
        this.id = id;
        this.className = className;
        this.filename = filename;
        this.parametersPrototype = parametersPrototype;
    }

    public String getId() {
        return id;
    }

    public Class<?> getClassName() {
        return className;
    }

    public String getFilename() {
        return filename;
    }

    public Optional<ParametersPrototype> getParametersPrototype() {
        return Optional.ofNullable(parametersPrototype);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("className", className)
                .add("filename", filename)
                .add("parametersPrototype", parametersPrototype)
                .toString();
    }
}
