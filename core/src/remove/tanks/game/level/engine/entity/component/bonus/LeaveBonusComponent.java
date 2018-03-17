package remove.tanks.game.level.engine.entity.component.bonus;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

/**
 * @author Mateusz Długosz
 */
public final class LeaveBonusComponent implements Component {
    public static final ComponentMapper<LeaveBonusComponent> MAPPER
            = ComponentMapper.getFor(LeaveBonusComponent.class);

    private final float chanceModifier;

    public LeaveBonusComponent(float chanceModifier) {
        this.chanceModifier = chanceModifier;
    }

    public float getChanceModifier() {
        return chanceModifier;
    }
}
