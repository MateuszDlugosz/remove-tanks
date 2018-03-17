package remove.tanks.game.level.engine.entity;

import com.badlogic.ashley.core.Entity;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.utility.surface.position.Position;

/**
 * @author Mateusz Długosz
 */
public final class EntityController {
    private final EntityCreator entityCreator;
    private final EntityPlacer entityPlacer;
    private final EntityDestroyer entityDestroyer;

    public EntityController(EntityCreator entityCreator, EntityPlacer entityPlacer, EntityDestroyer entityDestroyer) {
        this.entityCreator = entityCreator;
        this.entityPlacer = entityPlacer;
        this.entityDestroyer = entityDestroyer;
    }

    public void createEntity(EntityPrefab entityPrefab, Position position, ResourceRegistry registry) {
        placeEntity(entityCreator.createEntity(entityPrefab, registry), position, registry);
    }

    public void createEntity(String entityPrefabCode, Position position, ResourceRegistry registry) {
        placeEntity(entityCreator.createEntity(entityPrefabCode, registry), position, registry);
    }

    public void placeEntity(Entity entity, Position position, ResourceRegistry registry) {
        entityPlacer.placeEntity(entity, position, registry);
    }

    public void destroyEntity(Entity entity, ResourceRegistry registry) {
        entityDestroyer.destroyEntity(entity, registry);
    }
}
