package remove.tanks.game.level.event.entity.destroy;

import com.badlogic.ashley.core.Engine;
import remove.tanks.game.level.engine.entity.component.lifecycle.DestroyComponent;
import remove.tanks.game.level.event.EventExecuteException;
import remove.tanks.game.level.event.SubEventExecutor;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

/**
 * @author Mateusz Długosz
 */
public final class DestroyFamilyEntityEventExecutor implements SubEventExecutor<DestroyFamilyEntityEvent> {
    @Override
    public void executeEvent(DestroyFamilyEntityEvent event, ResourceRegistry registry) {
        try {
            registry.getResource(ResourceType.EngineResource, Engine.class)
                    .getEntitiesFor(event.getEntityFamily().getFamily())
                    .forEach(e -> e.add(new DestroyComponent()));
        } catch (Exception e) {
            throw new EventExecuteException(event, e);
        }
    }

    @Override
    public Class<DestroyFamilyEntityEvent> getExecutorType() {
        return DestroyFamilyEntityEvent.class;
    }
}
