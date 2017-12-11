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
    private final Map<Class<? extends EntitySystemPrototype>, RegistrableEntitySystemFactory> subFactories
            = new HashMap<>();

    public EntitySystemFactory(RegistrableEntitySystemFactory[] subFactories) {
        Arrays.stream(subFactories).forEach(s -> this.subFactories.put(s.getFactoryType(), s));
    }

    public List<EntitySystem> createEntitiesSystems(List<EntitySystemPrototype> prototypes, ResourceRegistry resourceRegistry) {
        return prototypes.stream()
                .map(p -> createEntitySystem(p, resourceRegistry))
                .collect(Collectors.toList());
    }

    public EntitySystem createEntitySystem(EntitySystemPrototype prototype, ResourceRegistry resourceRegistry) {
        try {
            if (!subFactories.containsKey(prototype.getClass())) {
                throw new EntitySystemFactoryNotFoundException(prototype.getClass());
            }
            return subFactories.get(prototype.getClass()).createEntitySystem(prototype, resourceRegistry);
        } catch (Exception e) {
            throw new EntitySystemCreateException(prototype, e);
        }
    }
}
