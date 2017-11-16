package remove.tanks.game.level.engine.entity.component.bonus;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * @author Mateusz Długosz
 */
public final class BonusLootComponent implements Component {
    public static final ComponentMapper<BonusLootComponent> MAPPER
            = ComponentMapper.getFor(BonusLootComponent.class);
}
