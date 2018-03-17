package remove.tanks.game.level.engine.entity.component.camera;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
import remove.tanks.game.utility.surface.position.Position;

/**
 * @author Mateusz Długosz
 */
public final class CameraTrackComponent implements Component {
    public static final ComponentMapper<CameraTrackComponent> MAPPER
            = ComponentMapper.getFor(CameraTrackComponent.class);

    private final Position position;
    private final int priority;

    public CameraTrackComponent(Position position, int priority) {
        this.position = position;
        this.priority = priority;
    }

    public Position getPosition() {
        return position;
    }

    public int getPriority() {
        return priority;
    }
}
