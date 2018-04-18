package remove.tanks.game.level.event.entity.airplane;

import com.badlogic.ashley.core.Engine;
import remove.tanks.game.level.engine.system.airplane.AirplaneControlSystem;
import remove.tanks.game.level.event.EventExecuteException;
import remove.tanks.game.level.event.SubEventExecutor;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public final class SpawnAirplaneEntityEventExecutor implements SubEventExecutor<SpawnAirplaneEntityEvent> {
    @Override
    public void executeEvent(SpawnAirplaneEntityEvent event, ResourceRegistry registry) {
        try {
            Optional.ofNullable(registry.getResource(ResourceType.EngineResource, Engine.class)
                    .getSystem(AirplaneControlSystem.class))
                    .ifPresent(AirplaneControlSystem::spawnAirplane);
        } catch (Exception e) {
            throw new EventExecuteException(event, e);
        }
    }

    @Override
    public Class<SpawnAirplaneEntityEvent> getExecutorType() {
        return SpawnAirplaneEntityEvent.class;
    }
}
