package remove.tanks.game.level.engine.entity.component.spawn;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * @author Mateusz Długosz
 */
public final class AirplaneSpawnerComponent implements Component {
    public static final ComponentMapper<AirplaneSpawnerComponent> MAPPER
            = ComponentMapper.getFor(AirplaneSpawnerComponent.class);

    private final String entityPrefabCode;

    public AirplaneSpawnerComponent(String entityPrefabCode) {
        this.entityPrefabCode = entityPrefabCode;
    }

    public String getEntityPrefabCode() {
        return entityPrefabCode;
    }
}
