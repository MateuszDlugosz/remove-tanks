package remove.tanks.game.level.event;

import remove.tanks.game.level.Level;

import java.util.*;

/**
 * @author Mateusz Długosz
 */
@SuppressWarnings("unchecked")
public final class EventExecutor {
    private final Map<Class<? extends Event>, RegistrableEventExecutor> executors
            = new HashMap<>();

    public EventExecutor(RegistrableEventExecutor[] executors) {
        Arrays.stream(executors).forEach(e -> this.executors.put(e.getExecutorType(), e));
    }

    public List<Object> executeEvents(List<Object> events, Level level) {
        List<Object> deadEvents = new ArrayList<>();
        events.forEach(e -> {
            if (executors.containsKey(e.getClass())) {
                executors.get(e.getClass()).executeEvent(e, level);
            } else {
                deadEvents.add(e);
            }
        });
        return deadEvents;
    }

    public Set<Class<? extends Event>> getSupportedEventClasses() {
        return executors.keySet();
    }
}
