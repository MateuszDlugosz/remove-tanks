package remove.tanks.game.level.event.entity.system;

import com.badlogic.ashley.core.Engine;
import remove.tanks.game.level.event.SubEventExecutor;
import remove.tanks.game.level.event.system.DeactivateSystemEvent;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public final class DeactivateSystemEntityEventExecutor implements SubEventExecutor<DeactivateSystemEntityEvent> {
    @Override
    public void executeEvent(DeactivateSystemEntityEvent event, ResourceRegistry registry) {
        Optional.ofNullable(registry.getResource(ResourceType.EngineResource, Engine.class)
                .getSystem(event.getSystemClass())).ifPresent(s -> s.setProcessing(false));
    }

    @Override
    public Class<DeactivateSystemEntityEvent> getExecutorType() {
        return DeactivateSystemEntityEvent.class;
    }
}
