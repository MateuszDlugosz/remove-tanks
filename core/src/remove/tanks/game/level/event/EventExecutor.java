package remove.tanks.game.level.event;

import remove.tanks.game.level.Level;

import java.util.*;

/**
 * @author Mateusz Długosz
 */
public final class EventExecutor {
    private final Map<Class<? extends Event>, RegistrableEventExecutor> executors
            = new HashMap<>();

    public EventExecutor(RegistrableEventExecutor[] executors) {
        Arrays.stream(executors).forEach(executor -> this.executors.put(executor.getExecutorType(), executor));
    }

    public List<Object> executeEvents(List<Object> events, Level level) {
        List<Object> deadEvents = new ArrayList<>();
        events.forEach(event -> {
            if (executors.containsKey(event.getClass())) {
                executors.get(event.getClass()).executeEvent(event, level);
            } else {
                deadEvents.add(event);
            }
        });
        return deadEvents;
    }
}
