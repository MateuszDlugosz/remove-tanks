package remove.tanks.game.level.utility.stage.widget;

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
public final class WidgetFactory {
    private final Map<Class<? extends WidgetPrefab>, SubWidgetFactory> factories = new HashMap<>();

    public WidgetFactory(SubWidgetFactory[] factories) {
        Arrays.stream(factories).forEach(f -> this.factories.put(f.getFactoryType(), f));
    }

    public List<Widget> createWidgets(List<WidgetPrefab> prefabs, Table table, ResourceRegistry registry) {
        return prefabs.stream()
                .map(p -> createWidget(p, table, registry))
                .collect(Collectors.toList());
    }

    public Widget createWidget(WidgetPrefab prefab, Table table, ResourceRegistry registry) {
        try {
            if (!factories.containsKey(prefab.getClass())) {
                throw new WidgetFactoryNotFoundException(prefab.getClass());
            }
            return factories.get(prefab.getClass()).createWidget(prefab, table, registry);
        } catch (Exception e) {
            throw new WidgetCreateException(prefab, e);
        }
    }
}
