package remove.tanks.game.level.engine.entity.component.spawn;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * @author Mateusz Długosz
 */
public final class AutoSpawnerComponent implements Component {
    public static final ComponentMapper<AutoSpawnerComponent> MAPPER
            = ComponentMapper.getFor(AutoSpawnerComponent.class);

    private final String id;

    public AutoSpawnerComponent(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
