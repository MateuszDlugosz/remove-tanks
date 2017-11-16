package remove.tanks.game.level.engine.entity.component.camera;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
import remove.tanks.game.utility.position.Position;

/**
 * @author Mateusz Długosz
 */
public final class CameraTrackingComponent implements Component {
    public static final ComponentMapper<CameraTrackingComponent> MAPPER
            = ComponentMapper.getFor(CameraTrackingComponent.class);

    private final Position position;

    public CameraTrackingComponent(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }
}
