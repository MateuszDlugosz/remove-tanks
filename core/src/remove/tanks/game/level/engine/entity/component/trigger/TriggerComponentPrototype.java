package remove.tanks.game.level.engine.entity.component.trigger;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrototype;
import remove.tanks.game.level.event.EventPrototype;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class TriggerComponentPrototype implements ComponentPrototype {
    private final List<EventPrototype> eventPrototypes;

    public TriggerComponentPrototype(List<EventPrototype> eventPrototypes) {
        this.eventPrototypes = eventPrototypes;
    }

    public List<EventPrototype> getEventPrototypes() {
        return eventPrototypes;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("eventPrototypes", eventPrototypes)
                .toString();
    }
}
