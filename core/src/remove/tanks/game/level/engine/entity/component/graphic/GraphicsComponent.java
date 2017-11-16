package remove.tanks.game.level.engine.entity.component.graphic;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
import remove.tanks.game.graphic.view.View;

import java.util.Map;
import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public final class GraphicsComponent implements Component {
    public static final ComponentMapper<GraphicsComponent> MAPPER
            = ComponentMapper.getFor(GraphicsComponent.class);

    private final Map<String, View> views;

    public GraphicsComponent(Map<String, View> views) {
        this.views = views;
    }

    public Optional<View> getView(String id) {
        return Optional.ofNullable(views.get(id));
    }
}
