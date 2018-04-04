package remove.tanks.game.level.event.entity.system;

import com.badlogic.ashley.core.Engine;
import remove.tanks.game.level.event.SubEventExecutor;
import remove.tanks.game.level.event.system.ActivateSystemEvent;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public final class ActivateSystemEntityEventExecutor implements SubEventExecutor<ActivateSystemEntityEvent> {
    @Override
    public void executeEvent(ActivateSystemEntityEvent event, ResourceRegistry registry) {
        Optional.ofNullable(registry.getResource(ResourceType.EngineResource, Engine.class)
                .getSystem(event.getSystemClass())).ifPresent(s -> s.setProcessing(true));
    }

    @Override
    public Class<ActivateSystemEntityEvent> getExecutorType() {
        return ActivateSystemEntityEvent.class;
    }
}
