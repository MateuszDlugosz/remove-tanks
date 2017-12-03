package remove.tanks.game.level.engine.entity.component.trigger;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
import remove.tanks.game.level.engine.utility.letter.NATOLetter;
import remove.tanks.game.level.event.Event;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class TriggerComponent implements Component {
    public static final ComponentMapper<TriggerComponent> MAPPER
            = ComponentMapper.getFor(TriggerComponent.class);

    private final List<Event> events;

    public TriggerComponent(List<Event> events) {
        this.events = events;
    }

    public List<Event> getEvents() {
        return events;
    }
}
