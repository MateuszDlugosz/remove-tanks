package remove.tanks.game.level.engine.entity;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.ComponentFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class EntityFactory {
    private final ComponentFactory componentFactory;

    public EntityFactory(ComponentFactory componentFactory) {
        this.componentFactory = componentFactory;
    }

    public Entity createEntity(EntityPrefab prefab, ResourceRegistry registry) {
        try {
            Entity entity = new Entity();
            prefab.getComponentPrefabs().values()
                    .forEach(c -> entity.add(componentFactory.createComponent(c, entity, registry)));
            return entity;
        } catch (Exception e) {
            throw new EntityCreateException(prefab, e);
        }
    }
}
