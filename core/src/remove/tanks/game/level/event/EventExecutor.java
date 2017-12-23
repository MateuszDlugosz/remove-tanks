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

    public void executeEvents(List<Object> events, Level level) {
        events.forEach(e -> {
            if (executors.containsKey(e.getClass())) {
                executors.get(e.getClass()).executeEvent(e, level);
            }
        });
    }

    public Set<Class<? extends Event>> getSupportedEventClasses() {
        return executors.keySet();
    }
}
