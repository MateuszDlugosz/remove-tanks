package remove.tanks.game.level.event;

import com.badlogic.ashley.core.Entity;
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
public final class EntityEventFactory {
    private Map<Class<? extends EntityEventPrefab>, SubEntityEventFactory> factories = new HashMap<>();

    public EntityEventFactory(SubEntityEventFactory[] factories) {
        Arrays.stream(factories).forEach(f -> this.factories.put(f.getFactoryType(), f));
    }

    public List<EntityEvent> createEntityEvents(List<EntityEventPrefab> prefabs, Entity entity, ResourceRegistry registry) {
        return prefabs.stream()
                .map(p -> createEntityEvent(p, entity, registry))
                .collect(Collectors.toList());
    }

    public EntityEvent createEntityEvent(EntityEventPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            if (!factories.containsKey(prefab.getClass())) {
                throw new EntityEventFactoryNotFoundException(prefab.getClass());
            }
            return factories.get(prefab.getClass()).createEntityEvent(prefab, entity, registry);
        } catch (Exception e) {
            throw new EntityEventCreateException(prefab, e);
        }
    }
}
