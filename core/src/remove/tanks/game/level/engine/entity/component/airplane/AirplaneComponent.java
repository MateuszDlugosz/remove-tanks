package remove.tanks.game.level.engine.entity.component.airplane;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * @author Mateusz Długosz
 */
public final class AirplaneComponent implements Component {
    private static final ComponentMapper<AirplaneComponent> MAPPER
            = ComponentMapper.getFor(AirplaneComponent.class);

    public static final AirplaneComponent INSTANCE = new AirplaneComponent();

    private AirplaneComponent() {}
}
