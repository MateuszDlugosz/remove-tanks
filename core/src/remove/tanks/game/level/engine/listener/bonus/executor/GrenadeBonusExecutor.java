package remove.tanks.game.level.engine.listener.bonus.executor;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.MathUtils;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.bonus.BonusType;
import remove.tanks.game.level.engine.entity.component.destroy.DestroyComponent;
import remove.tanks.game.level.engine.entity.component.destroy.DestroyOnContactComponent;
import remove.tanks.game.level.engine.entity.component.shoot.AmmoComponent;
import remove.tanks.game.level.engine.listener.bonus.BonusPickUpListener;

/**
 * @author Mateusz Długosz
 */
public final class GrenadeBonusExecutor implements BonusExecutor {
    @Override
    public void executeBonus(Entity bonusEntity, BonusPickUpListener listener) {
        listener.getEngine().getEntitiesFor(EntityFamily.EnemiesFamily.getFamily()).forEach(
                e -> e.add(new DestroyComponent())
        );
    }

    @Override
    public BonusType getExecutorType() {
        return BonusType.GrenadeBonus;
    }
}
