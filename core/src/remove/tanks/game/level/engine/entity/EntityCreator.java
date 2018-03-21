package remove.tanks.game.level.engine.entity;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.engine.entity.component.lifecycle.CreateComponent;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class EntityCreator {
    private final EntityFactory entityFactory;
    private final EntityPrefabStorage entityPrefabStorage;

    public EntityCreator(EntityFactory entityFactory, EntityPrefabStorage entityPrefabStorage) {
        this.entityFactory = entityFactory;
        this.entityPrefabStorage = entityPrefabStorage;
    }

    public Entity createEntity(String prefabCode, ResourceRegistry registry) {
        return createEntity(entityPrefabStorage.getEntityPrefab(prefabCode), registry);
    }

    public Entity createEntity(EntityPrefab entityPrefab, ResourceRegistry registry) {
        Entity entity = entityFactory.createEntity(entityPrefab, registry);
        entity.add(CreateComponent.INSTANCE);
        return entity;
    }
}
