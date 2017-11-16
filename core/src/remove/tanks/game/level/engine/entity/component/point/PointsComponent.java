package remove.tanks.game.level.engine.entity.component.point;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * @author Mateusz Długosz
 */
public final class PointsComponent implements Component {
    public static final ComponentMapper<PointsComponent> MAPPER
            = ComponentMapper.getFor(PointsComponent.class);

    private final int points;

    public PointsComponent(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }
}
