package remove.tanks.game.level.engine.entity.component.behavior;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class ChangeBehaviorComponent implements Component {
    public static final ComponentMapper<ChangeBehaviorComponent> MAPPER
            = ComponentMapper.getFor(ChangeBehaviorComponent.class);

    private final List<Component> components;

    public ChangeBehaviorComponent(List<Component> components) {
        this.components = components;
    }

    public List<Component> getComponents() {
        return components;
    }
}
