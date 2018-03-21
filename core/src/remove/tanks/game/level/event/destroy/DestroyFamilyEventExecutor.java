package remove.tanks.game.level.event.destroy;

import com.badlogic.ashley.core.Engine;
import remove.tanks.game.level.engine.entity.component.lifecycle.DestroyComponent;
import remove.tanks.game.level.event.EventExecuteException;
import remove.tanks.game.level.event.SubEventExecutor;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

/**
 * @author Mateusz Długosz
 */
public final class DestroyFamilyEventExecutor implements SubEventExecutor<DestroyFamilyEvent> {
    @Override
    public void executeEvent(DestroyFamilyEvent event, ResourceRegistry registry) {
        try {
            registry.getResource(ResourceType.EngineResource, Engine.class)
                    .getEntitiesFor(event.getEntityFamily().getFamily())
                    .forEach(e -> e.add(DestroyComponent.INSTANCE));
        } catch (Exception e) {
            throw new EventExecuteException(event, e);
        }
    }

    @Override
    public Class<DestroyFamilyEvent> getExecutorType() {
        return DestroyFamilyEvent.class;
    }
}
