package remove.tanks.game.level.engine.listener.bonus.executor;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.constant.LevelProperty;
import remove.tanks.game.level.engine.entity.component.bonus.BonusType;
import remove.tanks.game.level.engine.listener.bonus.BonusPickUpListener;
import remove.tanks.game.level.event.property.ModifyPropertyEvent;

/**
 * @author Mateusz Długosz
 */
public final class LifeBonusExecutor implements BonusExecutor {
    @Override
    public void executeBonus(Entity bonusEntity, BonusPickUpListener listener) {
        listener.getEventBus().post(new ModifyPropertyEvent(
                LevelProperty.LevelLifes,
                String.valueOf((listener.getProperties().getInt(LevelProperty.LevelLifes.getName()) + 1))
        ));
    }

    @Override
    public BonusType getExecutorType() {
        return BonusType.LifeBonus;
    }
}
