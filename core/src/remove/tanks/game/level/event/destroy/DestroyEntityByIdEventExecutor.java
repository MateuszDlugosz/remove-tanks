package remove.tanks.game.level.event.destroy;

import com.badlogic.ashley.core.Engine;
import remove.tanks.game.level.engine.entity.EntityFamily;
import remove.tanks.game.level.engine.entity.component.identity.IdentityComponent;
import remove.tanks.game.level.engine.entity.component.lifecycle.DestroyComponent;
import remove.tanks.game.level.event.EventExecuteException;
import remove.tanks.game.level.event.SubEventExecutor;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public final class DestroyEntityByIdEventExecutor implements SubEventExecutor<DestroyEntityByIdEvent> {
    @Override
    public void executeEvent(DestroyEntityByIdEvent event, ResourceRegistry registry) {
        try {
            registry.getResource(ResourceType.EngineResource, Engine.class)
                    .getEntitiesFor(EntityFamily.IdentityFamily.getFamily()).forEach(e ->
                Optional.ofNullable(IdentityComponent.MAPPER.get(e)).ifPresent(c -> {
                    if (c.getId().equals(event.getId())) {
                        e.add(new DestroyComponent());
                    }
                })
            );
        } catch (Exception e) {
            throw new EventExecuteException(event, e);
        }
    }

    @Override
    public Class<DestroyEntityByIdEvent> getExecutorType() {
        return DestroyEntityByIdEvent.class;
    }
}
