package remove.tanks.game.level.engine.entity.component.cloud;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * @author Mateusz Długosz
 */
public final class CloudComponent implements Component {
    private static final ComponentMapper<CloudComponent> MAPPER
            = ComponentMapper.getFor(CloudComponent.class);

    public static final CloudComponent INSTANCE = new CloudComponent();

    private CloudComponent() {}
}
