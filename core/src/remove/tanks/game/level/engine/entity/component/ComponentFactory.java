package remove.tanks.game.level.engine.entity.component;

import com.badlogic.ashley.core.Component;
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
public final class ComponentFactory {
    private final Map<Class<? extends ComponentPrefab>, SubComponentFactory> factories
            = new HashMap<>();

    public ComponentFactory(SubComponentFactory[] factories) {
        Arrays.stream(factories).forEach(s -> this.factories.put(s.getFactoryType(), s));
    }

    public List<Component> createComponents(List<ComponentPrefab> prefabs, Entity entity, ResourceRegistry registry) {
        return prefabs.stream()
                .map(p -> createComponent(p, entity, registry))
                .collect(Collectors.toList());
    }

    public Component createComponent(ComponentPrefab prefab, Entity entity, ResourceRegistry registry) {
        try {
            if (!factories.containsKey(prefab.getClass())) {
                throw new ComponentFactoryNotFoundException(prefab.getClass().toString());
            }
            return factories.get(prefab.getClass()).createComponent(prefab, entity, registry);
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }
}
