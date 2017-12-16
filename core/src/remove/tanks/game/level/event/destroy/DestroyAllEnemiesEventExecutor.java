package remove.tanks.game.level.event.destroy;

import com.badlogic.ashley.core.Engine;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.destroy.DestroyComponent;
import remove.tanks.game.level.event.RegistrableEventExecutor;

/**
 * @author Mateusz Długosz
 */
public final class DestroyAllEnemiesEventExecutor
        implements RegistrableEventExecutor<DestroyAllEnemiesEvent>
{
    @Override
    public void executeEvent(DestroyAllEnemiesEvent event, Level level) {
        level.getResourceRegistry().getResource(LevelResource.Engine.toString(), Engine.class)
                .getEntitiesFor(EntityFamily.EnemiesFamily.getFamily())
                .forEach(e -> e.add(new DestroyComponent()));
    }

    @Override
    public Class<DestroyAllEnemiesEvent> getExecutorType() {
        return DestroyAllEnemiesEvent.class;
    }
}
