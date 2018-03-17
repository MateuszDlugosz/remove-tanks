package remove.tanks.game.level.engine.entity.component.trigger;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.ComponentCreateException;
import remove.tanks.game.level.engine.entity.component.SubComponentFactory;
import remove.tanks.game.level.event.EntityEvent;
import remove.tanks.game.level.event.EntityEventFactory;
import remove.tanks.game.level.event.EntityEventPrefab;
import remove.tanks.game.level.resource.ResourceRegistry;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public abstract class AbstractTriggerComponentFactory<T extends AbstractTriggerComponent, U extends AbstractTriggerComponentPrefab>
        implements SubComponentFactory<T, U>
{
    private final EntityEventFactory entityEventFactory;

    public AbstractTriggerComponentFactory(EntityEventFactory entityEventFactory) {
        this.entityEventFactory = entityEventFactory;
    }

    @Override
    public final T createComponent(U prefab, Entity entity, ResourceRegistry registry) {
        try {
            return createComponent(createEntityEvents(prefab.getEntityEventPrefabs(), entity, registry));
        } catch (Exception e) {
            throw new ComponentCreateException(prefab, e);
        }
    }

    protected abstract T createComponent(List<EntityEvent> entityEvents);

    private List<EntityEvent> createEntityEvents(List<EntityEventPrefab> entityEventPrefabs, Entity entity, ResourceRegistry registry) {
        return entityEventFactory.createEntityEvents(entityEventPrefabs, entity, registry);
    }
}
