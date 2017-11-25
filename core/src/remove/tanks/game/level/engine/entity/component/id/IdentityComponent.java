package remove.tanks.game.level.engine.entity.component.id;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * @author Mateusz Długosz
 */
public final class IdentityComponent implements Component {
    public static final ComponentMapper<IdentityComponent> MAPPER
            = ComponentMapper.getFor(IdentityComponent.class);

    private final String id;

    public IdentityComponent(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
