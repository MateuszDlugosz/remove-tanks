package remove.tanks.game.level.engine.entity.component.lifecycle;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

public final class DestroyOnContactComponent implements Component {
    public static final ComponentMapper<DestroyOnContactComponent> MAPPER
            = ComponentMapper.getFor(DestroyOnContactComponent.class);

    public static final DestroyOnContactComponent INSTANCE = new DestroyOnContactComponent();

    private DestroyOnContactComponent() {}
}
