package remove.tanks.game.level.engine.listener.bonus.executor;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.bonus.BonusType;
import remove.tanks.game.level.engine.listener.bonus.BonusPickUpListener;
import remove.tanks.game.level.event.points.IncreasePointsMultiplierEvent;

/**
 * @author Mateusz Długosz
 */
public final class PromotionBonusExecutor implements BonusExecutor {
    @Override
    public void executeBonus(Entity bonusEntity, BonusPickUpListener listener) {
        listener.getEventBus().post(new IncreasePointsMultiplierEvent());
    }

    @Override
    public BonusType getExecutorType() {
        return BonusType.PromotionBonus;
    }
}
