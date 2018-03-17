package remove.tanks.game.level.engine.entity.component.trigger;

import com.badlogic.ashley.core.Component;
import remove.tanks.game.level.event.EntityEvent;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public abstract class AbstractTriggerComponent implements Component {
    private final List<EntityEvent> entityEvents;

    public AbstractTriggerComponent(List<EntityEvent> entityEvents) {
        this.entityEvents = entityEvents;
    }

    public List<EntityEvent> getEntityEvents() {
        return entityEvents;
    }
}
