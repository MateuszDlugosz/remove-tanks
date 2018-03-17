package remove.tanks.game.level.engine.entity.component.render;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
import remove.tanks.game.graphics.view.View;

import java.util.Map;
import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public final class ViewComponent implements Component {
    public static final ComponentMapper<ViewComponent> MAPPER
            = ComponentMapper.getFor(ViewComponent.class);

    private final Map<String, View> views;

    public ViewComponent(Map<String, View> views) {
        this.views = views;
    }

    public Map<String, View> getViews() {
        return views;
    }

    public Optional<View> getView(String id) {
        return Optional.ofNullable(views.get(id));
    }
}
