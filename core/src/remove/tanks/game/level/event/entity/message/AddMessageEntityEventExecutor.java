package remove.tanks.game.level.event.entity.message;

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
public final class AddMessageEntityEventExecutor implements SubEventExecutor<AddMessageEntityEvent> {
    @Override
    public void executeEvent(AddMessageEntityEvent event, ResourceRegistry registry) {
        try {
            Optional.ofNullable(registry.getResource(ResourceType.EngineResource, Engine.class)
                    .getSystem(HudSystem.class))
                    .ifPresent(s -> s.addMessage(event.getMessage()));
        } catch (Exception e) {
            throw new EventExecuteException(event, e);
        }
    }

    @Override
    public Class<AddMessageEntityEvent> getExecutorType() {
        return AddMessageEntityEvent.class;
    }
}
