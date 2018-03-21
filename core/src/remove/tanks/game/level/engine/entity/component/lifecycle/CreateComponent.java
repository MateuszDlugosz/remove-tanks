package remove.tanks.game.level.engine.entity.component.lifecycle;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * @author Mateusz Długosz
 */
public final class CreateComponent implements Component {
    public static final ComponentMapper<CreateComponent> MAPPER
            = ComponentMapper.getFor(CreateComponent.class);

    public static final CreateComponent INSTANCE = new CreateComponent();

    private CreateComponent() {}
}
