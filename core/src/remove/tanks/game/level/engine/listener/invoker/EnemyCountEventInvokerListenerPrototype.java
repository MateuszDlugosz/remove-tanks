package remove.tanks.game.level.engine.listener.invoker;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.listener.EntityListenerPrototype;
import remove.tanks.game.level.event.EventPrototype;

import java.util.List;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class EnemyCountEventInvokerListenerPrototype extends EntityListenerPrototype {
    private final Map<Integer, List<EventPrototype>> eventPrototypes;

    public EnemyCountEventInvokerListenerPrototype(
            int priority,
            Map<Integer, List<EventPrototype>> eventPrototypes
    ) {
        super(priority);
        this.eventPrototypes = eventPrototypes;
    }

    public Map<Integer, List<EventPrototype>> getEventPrototypes() {
        return eventPrototypes;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("eventPrototypes", eventPrototypes)
                .toString();
    }
}
