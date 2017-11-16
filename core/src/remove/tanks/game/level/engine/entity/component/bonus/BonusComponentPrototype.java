package remove.tanks.game.level.engine.entity.component.bonus;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrototype;

/**
 * @author Mateusz Długosz
 */
public final class BonusComponentPrototype implements ComponentPrototype {
    private final BonusType bonusType;

    public BonusComponentPrototype(BonusType bonusType) {
        this.bonusType = bonusType;
    }

    public BonusType getBonusType() {
        return bonusType;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("bonusType", bonusType)
                .toString();
    }
}
