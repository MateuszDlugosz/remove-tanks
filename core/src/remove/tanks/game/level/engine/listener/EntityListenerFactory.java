package remove.tanks.game.level.engine.listener;

import com.badlogic.ashley.core.Engine;
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
public final class EntityListenerFactory {
    private final Map<Class<? extends EntityListenerPrefab>, SubEntityListenerFactory> factories
            = new HashMap<>();

    public EntityListenerFactory(SubEntityListenerFactory[] factories) {
        Arrays.stream(factories).forEach(s -> this.factories.put(s.getFactoryType(), s));
    }

    public List<AbstractEntityListener> createEntitiesListeners(List<EntityListenerPrefab> prefabs, ResourceRegistry registry, Engine engine) {
        return prefabs.stream()
                .map(p -> createEntityListener(p, registry, engine))
                .collect(Collectors.toList());
    }

    public AbstractEntityListener createEntityListener(EntityListenerPrefab prefab, ResourceRegistry registry, Engine engine) {
        try {
            if (!factories.containsKey(prefab.getClass())) {
                throw new EntityListenerFactoryNotFoundException(prefab.getClass());
            }
            return factories.get(prefab.getClass()).createEntityListener(prefab, registry, engine);
        } catch (Exception e) {
            throw new EntityListenerCreateException(prefab, e);
        }
    }
}
