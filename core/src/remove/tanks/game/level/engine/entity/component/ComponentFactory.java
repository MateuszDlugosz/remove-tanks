package remove.tanks.game.level.engine.entity.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.Level;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class ComponentFactory {
    private final Map<Class<? extends ComponentPrototype>, RegistrableComponentFactory> subFactories
            = new HashMap<>();

    public ComponentFactory(RegistrableComponentFactory[] subFactories) {
        Arrays.stream(subFactories).forEach(s -> this.subFactories.put(s.getFactoryType(), s));
    }

    public List<Component> createComponents(List<ComponentPrototype> prototypes, Level level, Entity entity) {
        return prototypes.stream()
                .map(p -> createComponent(p, level, entity))
                .collect(Collectors.toList());
    }

    public Component createComponent(ComponentPrototype prototype, Level level, Entity entity) {
        if (!subFactories.containsKey(prototype.getClass())) {
            throw new ComponentFactoryNotFoundException(prototype.getClass().toString());
        }
        try {
            return subFactories.get(prototype.getClass()).createComponent(prototype, level, entity);
        } catch (Exception e) {
            throw new ComponentCreateException(prototype, e);
        }
    }
}
