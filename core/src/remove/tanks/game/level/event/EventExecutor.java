package remove.tanks.game.level.event;

import remove.tanks.game.level.resource.ResourceRegistry;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
@SuppressWarnings("unchecked")
public final class EventExecutor {
    private final Map<Class<? extends Event>, SubEventExecutor> executors = new HashMap<>();

    public EventExecutor(SubEventExecutor[] executors) {
        Arrays.stream(executors).forEach(e -> this.executors.put(e.getExecutorType(), e));
    }

    public void executeEvents(List<Event> events, ResourceRegistry registry) {
        events.forEach(e -> executeEvent(e, registry));
    }

    public void executeEvent(Event event, ResourceRegistry registry) {
        try {
            if (!executors.containsKey(event.getClass())) {
                throw new EventExecutorNotFoundException(event.getClass());
            }
            executors.get(event.getClass()).executeEvent(event, registry);
        } catch (Exception e) {
            throw new EventExecuteException(event, e);
        }
    }
}
