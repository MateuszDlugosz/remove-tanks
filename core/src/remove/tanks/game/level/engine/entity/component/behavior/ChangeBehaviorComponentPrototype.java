package remove.tanks.game.level.engine.entity.component.behavior;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrototype;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class ChangeBehaviorComponentPrototype implements ComponentPrototype {
    private final List<ComponentPrototype> componentPrototypes;

    public ChangeBehaviorComponentPrototype(List<ComponentPrototype> componentPrototypes) {
        this.componentPrototypes = componentPrototypes;
    }

    public List<ComponentPrototype> getComponentPrototypes() {
        return componentPrototypes;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("componentPrototypes", componentPrototypes)
                .toString();
    }
}
