package remove.tanks.game.level.engine.listener.bonus.executor;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.MathUtils;
import remove.tanks.game.level.engine.entity.component.bonus.BonusType;
import remove.tanks.game.level.engine.entity.component.destroy.DestroyOnContactComponent;
import remove.tanks.game.level.engine.entity.component.shoot.AmmoComponent;
import remove.tanks.game.level.engine.listener.bonus.BonusPickUpListener;

/**
 * @author Mateusz Długosz
 */
public final class AmmoBonusExecutor implements BonusExecutor {
    @Override
    public void executeBonus(Entity bonusEntity, BonusPickUpListener listener) {
        DestroyOnContactComponent docc = DestroyOnContactComponent.MAPPER.get(bonusEntity);
        if (docc.getContactedWith().isPresent()) {
            Entity entity = docc.getContactedWith().get();
            if (entity.getComponent(AmmoComponent.class) != null) {
                AmmoComponent ac = AmmoComponent.MAPPER.get(entity);
                entity.add(
                        new AmmoComponent(
                                MathUtils.clamp(ac.getCurrentLevel()+1, 1, ac.getMaxLevel()),
                                ac.getMaxLevel(),
                                ac.getPrototypeCodes()
                        )
                );
            }
        }
    }

    @Override
    public BonusType getExecutorType() {
        return BonusType.AmmoBonus;
    }
}
