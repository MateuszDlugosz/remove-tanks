package remove.tanks.game.level.event.message;

import com.badlogic.ashley.core.Engine;
import remove.tanks.game.level.engine.system.hud.HudSystem;
import remove.tanks.game.level.event.EventExecuteException;
import remove.tanks.game.level.event.SubEventExecutor;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public final class ClearMessagesEventExecutor implements SubEventExecutor<ClearMessagesEvent> {
    @Override
    public void executeEvent(ClearMessagesEvent event, ResourceRegistry registry) {
        try {
            Optional.ofNullable(registry.getResource(ResourceType.EngineResource, Engine.class)
                    .getSystem(HudSystem.class))
                    .ifPresent(HudSystem::clearMessages);
        } catch (Exception e) {
            throw new EventExecuteException(event, e);
        }
    }

    @Override
    public Class<ClearMessagesEvent> getExecutorType() {
        return null;
    }
}
