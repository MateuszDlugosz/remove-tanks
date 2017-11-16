package remove.tanks.game.level.engine.entity.component.bonus;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * @author Mateusz Długosz
 */
public final class BonusComponent implements Component {
    public static final ComponentMapper<BonusComponent> MAPPER
            = ComponentMapper.getFor(BonusComponent.class);

    private final BonusType bonusType;

    public BonusComponent(BonusType bonusType) {
        this.bonusType = bonusType;
    }

    public BonusType getBonusType() {
        return bonusType;
    }
}
