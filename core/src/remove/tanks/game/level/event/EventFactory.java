package remove.tanks.game.level.event;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class EventFactory {
    private final Map<String, RegistrableEventFactory> factories
            = new HashMap<>();

    public EventFactory(RegistrableEventFactory[] factories) {
        Arrays.stream(factories).forEach(factory -> this.factories.put(factory.getFactoryType().getName(), factory));
    }

    public List<Event> createEvents(List<EventPrototype> prototypes) {
        return prototypes.stream()
                .map(this::createEvent)
                .collect(Collectors.toList());
    }

    public Event createEvent(EventPrototype prototype) {
        String type = prototype.getClass().getName();
        if (!factories.containsKey(type)) {
            throw new EventFactoryNotFoundException(type);
        }
        try {
            return factories.get(type).createEvent(prototype);
        } catch (Exception e) {
            throw new EventCreateException(prototype, e);
        }
    }
}
