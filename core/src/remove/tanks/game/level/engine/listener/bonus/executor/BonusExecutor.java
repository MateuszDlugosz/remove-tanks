package remove.tanks.game.level.engine.listener.bonus.executor;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.bonus.BonusType;
import remove.tanks.game.level.engine.listener.bonus.BonusPickUpListener;

/**
 * @author Mateusz Długosz
 */
public interface BonusExecutor {
    void executeBonus(Entity bonusEntity, BonusPickUpListener bonusListener);
    BonusType getExecutorType();
}
