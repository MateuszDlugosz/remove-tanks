package remove.tanks.game.level.event.system;

import com.badlogic.ashley.core.Engine;
import remove.tanks.game.level.event.SubEventExecutor;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public final class DeactivateSystemEventExecutor implements SubEventExecutor<DeactivateSystemEvent> {
    @Override
    public void executeEvent(DeactivateSystemEvent event, ResourceRegistry registry) {
        Optional.ofNullable(registry.getResource(ResourceType.EngineResource, Engine.class)
                .getSystem(event.getSystemClass())).ifPresent(s -> s.setProcessing(false));
    }

    @Override
    public Class<DeactivateSystemEvent> getExecutorType() {
        return DeactivateSystemEvent.class;
    }
}
