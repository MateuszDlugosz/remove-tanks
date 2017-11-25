package remove.tanks.game.level.engine.entity;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrototype;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class EntityPrototype implements Serializable {
    private final String filename;
    private final Map<Class<? extends ComponentPrototype>, ComponentPrototype> componentPrototypes;

    public EntityPrototype(String filename, Map<Class<? extends ComponentPrototype>, ComponentPrototype> componentPrototypes) {
        this.filename = filename;
        this.componentPrototypes = componentPrototypes;
    }

    public String getFilename() {
        return filename;
    }

    public Map<Class<? extends ComponentPrototype>, ComponentPrototype> getComponentPrototypes() {
        return componentPrototypes;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("filename", filename)
                .add("componentPrototypes", componentPrototypes)
                .toString();
    }
}
