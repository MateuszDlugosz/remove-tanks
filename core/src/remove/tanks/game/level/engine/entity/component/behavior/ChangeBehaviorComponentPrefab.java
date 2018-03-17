package remove.tanks.game.level.engine.entity.component.behavior;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrefab;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class ChangeBehaviorComponentPrefab extends ComponentPrefab {
    private final List<ComponentPrefab> componentPrefabs;

    public ChangeBehaviorComponentPrefab(List<ComponentPrefab> componentPrefabs) {
        this.componentPrefabs = componentPrefabs;
    }

    public List<ComponentPrefab> getComponentPrefabs() {
        return componentPrefabs;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("componentPrefabs", componentPrefabs)
                .toString();
    }
}
