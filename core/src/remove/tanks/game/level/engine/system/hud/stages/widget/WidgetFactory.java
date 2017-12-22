package remove.tanks.game.level.engine.system.hud.stages.widget;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
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
public final class WidgetFactory {
    private final Map<Class<? extends WidgetPrototype>, RegistrableWidgetFactory> factories
            = new HashMap<>();

    public WidgetFactory(RegistrableWidgetFactory[] factories) {
        Arrays.stream(factories).forEach(f -> this.factories.put(f.getFactoryType(), f));
    }

    public List<Widget> createWidgets(List<WidgetPrototype> prototypes, Table table, ResourceRegistry resourceRegistry) {
        return prototypes.stream()
                .map(p -> createWidget(p, table, resourceRegistry))
                .collect(Collectors.toList());
    }

    public Widget createWidget(WidgetPrototype prototype, Table table, ResourceRegistry resourceRegistry) {
        try {
            if (!factories.containsKey(prototype.getClass())) {
                throw new WidgetFactoryNotFoundException(prototype.getClass());
            }
            return factories.get(prototype.getClass()).createWidget(prototype, table, resourceRegistry);
        } catch (Exception e) {
            throw new WidgetCreateException(prototype, e);
        }
    }
}
