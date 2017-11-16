package remove.tanks.game.level.engine.entity;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrototype;

import java.io.Serializable;
import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class EntityPrototype implements Serializable {
    private final String filename;
    private final List<ComponentPrototype> componentsPrototypes;

    public EntityPrototype(String filename, List<ComponentPrototype> componentsPrototypes) {
        this.filename = filename;
        this.componentsPrototypes = componentsPrototypes;
    }

    public String getFilename() {
        return filename;
    }

    public List<ComponentPrototype> getComponentsPrototypes() {
        return componentsPrototypes;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("filename", filename)
                .add("componentsPrototypes", componentsPrototypes)
                .toString();
    }
}
