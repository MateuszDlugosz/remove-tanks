package remove.tanks.game.level.engine.system;

import com.badlogic.ashley.core.EntitySystem;
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
public final class EntitySystemFactory {
    private final Map<Class<? extends EntitySystemPrefab>, SubEntitySystemFactory> factories
            = new HashMap<>();

    public EntitySystemFactory(SubEntitySystemFactory[] factories) {
        Arrays.stream(factories).forEach(s -> this.factories.put(s.getFactoryType(), s));
    }

    public List<EntitySystem> createEntitiesSystems(List<EntitySystemPrefab> prefabs, ResourceRegistry registry) {
        return prefabs.stream()
                .map(p -> createEntitySystem(p, registry))
                .collect(Collectors.toList());
    }

    public EntitySystem createEntitySystem(EntitySystemPrefab prefab, ResourceRegistry registry) {
        try {
            if (!factories.containsKey(prefab.getClass())) {
                throw new EntitySystemFactoryNotFoundException(prefab.getClass());
            }
            return factories.get(prefab.getClass()).createEntitySystem(prefab, registry);
        } catch (Exception e) {
            throw new EntitySystemCreateException(prefab, e);
        }
    }
}
