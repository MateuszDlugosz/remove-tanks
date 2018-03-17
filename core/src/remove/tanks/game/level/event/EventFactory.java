package remove.tanks.game.level.event;

import remove.tanks.game.level.resource.ResourceRegistry;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
@SuppressWarnings("unchecked")
public final class EventFactory {
    private final Map<Class<? extends EventPrefab>, SubEventFactory> factories = new HashMap<>();

    public EventFactory(SubEventFactory[] factories) {
        Arrays.stream(factories).forEach(f -> this.factories.put(f.getFactoryType(), f));
    }

    public List<Event> createEvents(List<EventPrefab> prefabs, ResourceRegistry registry) {
        return prefabs.stream()
                .map(p -> createEvent(p, registry))
                .collect(Collectors.toList());
    }

    public Event createEvent(EventPrefab prefab, ResourceRegistry registry) {
        try {
            if (!factories.containsKey(prefab.getClass())) {
                throw new EventFactoryNotFoundException(prefab.getClass());
            }
            return factories.get(prefab.getClass()).createEvent(prefab, registry);
        } catch (Exception e) {
            throw new EventCreateException(prefab, e);
        }
    }
}
