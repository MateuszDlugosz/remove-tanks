package remove.tanks.game.level.event;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class EventFactory {
    private final Map<String, RegistrableEventFactory> factories
            = new HashMap<>();

    public EventFactory(RegistrableEventFactory[] factories) {
        Arrays.stream(factories).forEach(factory -> this.factories.put(factory.getFactoryType().getName(), factory));
    }

    public Event createEvent(EventPrototype prototype) {
        String type = prototype.getClass().getName();
        if (!factories.containsKey(type)) {
            throw new EventCreateException(prototype);
        }
        return factories.get(type).createEvent(prototype);
    }
}
