package remove.tanks.game.level.event.entity.artillery;

import com.badlogic.ashley.core.Engine;
import remove.tanks.game.level.engine.system.artillery.ArtilleryControlSystem;
import remove.tanks.game.level.event.EventExecuteException;
import remove.tanks.game.level.event.SubEventExecutor;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public final class ArtilleryShootEntityEventExecutor implements SubEventExecutor<ArtilleryShootEntityEvent> {
    @Override
    public void executeEvent(ArtilleryShootEntityEvent event, ResourceRegistry registry) {
        try {
            Optional.ofNullable(registry.getResource(ResourceType.EngineResource, Engine.class)
                    .getSystem(ArtilleryControlSystem.class))
                    .ifPresent(ArtilleryControlSystem::shoot);
        } catch (Exception e) {
            throw new EventExecuteException(event, e);
        }
    }

    @Override
    public Class<ArtilleryShootEntityEvent> getExecutorType() {
        return ArtilleryShootEntityEvent.class;
    }
}
