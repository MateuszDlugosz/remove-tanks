package remove.tanks.game.level.engine.entity.component.combat;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * @author Mateusz Długosz
 */
public final class ProtectionComponent implements Component {
    public static final ComponentMapper<ProtectionComponent> MAPPER
            = ComponentMapper.getFor(ProtectionComponent.class);

    public static final ProtectionComponent INSTANCE = new ProtectionComponent();

    private ProtectionComponent() {}
}
