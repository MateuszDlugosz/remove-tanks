package remove.tanks.game.level.engine.entity.component.faction;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * @author Mateusz Długosz
 */
public final class EnemyComponent implements Component {
    public static final ComponentMapper<EnemyComponent> MAPPER
            = ComponentMapper.getFor(EnemyComponent.class);

    public static final EnemyComponent INSTANCE = new EnemyComponent();

    private EnemyComponent() {}
}
