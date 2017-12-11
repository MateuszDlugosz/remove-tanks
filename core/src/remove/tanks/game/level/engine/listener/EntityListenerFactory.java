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
    private final Map<Class<? extends EntityListenerPrototype>, RegistrableEntityListenerFactory> subFactories
            = new HashMap<>();

    public EntityListenerFactory(RegistrableEntityListenerFactory[] subFactories) {
        Arrays.stream(subFactories).forEach(s -> this.subFactories.put(s.getFactoryType(), s));
    }

    public List<ExtendedEntityListener> createEntitiesListeners(List<EntityListenerPrototype> prototypes,
                                                                ResourceRegistry registry,
                                                                Engine engine
    ) {
        return prototypes.stream()
                .map(p -> createEntityListener(p, registry, engine))
                .collect(Collectors.toList());
    }

    public ExtendedEntityListener createEntityListener(EntityListenerPrototype prototype, ResourceRegistry registry, Engine engine) {
        try {
            if (!subFactories.containsKey(prototype.getClass())) {
                throw new EntityListenerFactoryNotFoundException(prototype.getClass());
            }
            return subFactories.get(prototype.getClass()).createEntityListener(prototype, registry, engine);
        } catch (Exception e) {
            throw new EntityListenerCreateException(prototype, e);
        }
    }
}
