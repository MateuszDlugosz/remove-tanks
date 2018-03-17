package remove.tanks.game.level.event.entity.spawner;

import com.badlogic.ashley.core.Engine;
import remove.tanks.game.level.engine.system.spawn.AutoSpawnerSystem;
import remove.tanks.game.level.event.EventExecuteException;
import remove.tanks.game.level.event.SubEventExecutor;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public final class ActivateSpawnerEntityEventExecutor implements SubEventExecutor<ActivateSpawnerEntityEvent> {
    @Override
    public void executeEvent(ActivateSpawnerEntityEvent event, ResourceRegistry registry) {
        try {
            Optional.ofNullable(registry.getResource(ResourceType.EngineResource, Engine.class)
                    .getSystem(AutoSpawnerSystem.class))
                    .ifPresent(s -> s.activateSpawner(event.getId()));
        } catch (Exception e) {
            throw new EventExecuteException(event, e);
        }
    }

    @Override
    public Class<ActivateSpawnerEntityEvent> getExecutorType() {
        return ActivateSpawnerEntityEvent.class;
    }
}
