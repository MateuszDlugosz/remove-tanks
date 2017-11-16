package remove.tanks.game.level.engine.listener.bonus.executor;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.bonus.BonusType;
import remove.tanks.game.level.engine.entity.component.physics.PhysicsComponent;
import remove.tanks.game.level.engine.entity.component.spawn.BombersSpawnerComponent;
import remove.tanks.game.level.engine.event.SpawnEntityEvent;
import remove.tanks.game.level.engine.listener.bonus.BonusPickUpListener;

/**
 * @author Mateusz Długosz
 */
public final class BombersBonusExecutor implements BonusExecutor {
    @Override
    public void executeBonus(Entity bonusEntity, BonusPickUpListener listener) {
        Entity spawner = listener.getEngine().getEntitiesFor(EntityFamily.BombersSpawnerFamily.getFamily()).random();
        if (spawner != null) {
            PhysicsComponent pc = PhysicsComponent.MAPPER.get(spawner);
            listener.getEventBus().post(new SpawnEntityEvent(
                    BombersSpawnerComponent.MAPPER.get(spawner).getPrototype(),
                    pc.getPosition()
            ));
        }
    }

    @Override
    public BonusType getExecutorType() {
        return BonusType.BombersBonus;
    }
}
