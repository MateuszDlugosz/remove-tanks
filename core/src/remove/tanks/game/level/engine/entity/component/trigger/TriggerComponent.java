package remove.tanks.game.level.engine.entity.component.trigger;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
import remove.tanks.game.level.event.Event;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class TriggerComponent implements Component {
    public static final ComponentMapper<TriggerComponent> MAPPER
            = ComponentMapper.getFor(TriggerComponent.class);

    private final List<Event> createEvents;
    private final List<Event> destroyEvents;

    public TriggerComponent(List<Event> createEvents, List<Event> destroyEvents) {
        this.createEvents = createEvents;
        this.destroyEvents = destroyEvents;
    }

    public List<Event> getCreateEvents() {
        return createEvents;
    }

    public List<Event> getDestroyEvents() {
        return destroyEvents;
    }
}
