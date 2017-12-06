package remove.tanks.game.level.event.spawner;

import com.badlogic.ashley.core.Engine;
import remove.tanks.game.level.Level;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.system.spawn.AutoSpawnerSystem;
import remove.tanks.game.level.event.RegistrableEventExecutor;

/**
 * @author Mateusz Długosz
 */
public final class ActivateAutoSpawnerEventExecutor
        implements RegistrableEventExecutor<ActivateAutoSpawnerEvent>
{
    @Override
    public void executeEvent(ActivateAutoSpawnerEvent event, Level level) {
        AutoSpawnerSystem system = level.getResourceRegistry().getResource(LevelResource.Engine.toString(), Engine.class)
                .getSystem(AutoSpawnerSystem.class);
        if (system != null) {
            system.activateSpawner(event.getId());
        }
    }

    @Override
    public Class<ActivateAutoSpawnerEvent> getExecutorType() {
        return ActivateAutoSpawnerEvent.class;
    }
}
