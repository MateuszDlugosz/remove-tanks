package remove.tanks.game.level.engine.listener.bonus.executor;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.constant.LevelProperty;
import remove.tanks.game.level.engine.entity.component.bonus.BonusType;
import remove.tanks.game.level.engine.entity.component.control.PlayerControlComponent;
import remove.tanks.game.level.engine.entity.component.destroy.DestroyOnContactComponent;
import remove.tanks.game.level.engine.entity.component.health.HealthComponent;
import remove.tanks.game.level.engine.event.ModifyPropertyEvent;
import remove.tanks.game.level.engine.listener.bonus.BonusPickUpListener;

/**
 * @author Mateusz Długosz
 */
public final class LifeBonusExecutor implements BonusExecutor {
    @Override
    public void executeBonus(Entity bonusEntity, BonusPickUpListener listener) {
        DestroyOnContactComponent docc = DestroyOnContactComponent.MAPPER.get(bonusEntity);
        if (docc.getContactedWith().isPresent()) {
            Entity entity = docc.getContactedWith().get();
            if (HealthComponent.MAPPER.has(entity)) {
                HealthComponent hc = HealthComponent.MAPPER.get(entity);
                if (hc.getHealth() < hc.getMaxHealth()) {
                    entity.add(new HealthComponent(
                            hc.getHealth()+1,
                            hc.getMaxHealth()
                    ));
                }
            }
            if (PlayerControlComponent.MAPPER.has(entity)) {
                listener.getEventBus().post(new ModifyPropertyEvent(
                        LevelProperty.LevelLifes,
                        String.valueOf((listener.getProperties().getInt(LevelProperty.LevelLifes.getName()) + 1))
                ));
            }
        }
    }

    @Override
    public BonusType getExecutorType() {
        return BonusType.LifeBonus;
    }
}
