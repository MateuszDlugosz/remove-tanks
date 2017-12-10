package remove.tanks.game.level.engine.entity.component.trigger;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrototype;
import remove.tanks.game.level.event.EventPrototype;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class TriggerComponentPrototype implements ComponentPrototype {
    private final List<EventPrototype> createEventPrototypes;
    private final List<EventPrototype> destroyEventPrototypes;

    public TriggerComponentPrototype(
            List<EventPrototype> createEventPrototypes,
            List<EventPrototype> destroyEventPrototypes
    ) {
        this.createEventPrototypes = createEventPrototypes;
        this.destroyEventPrototypes = destroyEventPrototypes;
    }

    public List<EventPrototype> getCreateEventPrototypes() {
        return createEventPrototypes;
    }

    public List<EventPrototype> getDestroyEventPrototypes() {
        return destroyEventPrototypes;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("createEventPrototypes", createEventPrototypes)
                .add("destroyEventPrototypes", destroyEventPrototypes)
                .toString();
    }
}
