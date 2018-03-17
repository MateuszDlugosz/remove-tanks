package remove.tanks.game.level.resource.factories;

import remove.tanks.game.level.engine.entity.*;
import remove.tanks.game.level.resource.AbstractLocalResourceFactory;
import remove.tanks.game.level.resource.ResourceDisposer;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

import java.util.EnumMap;

/**
 * @author Mateusz Długosz
 */
public final class EntityControllerLocalResourceFactory extends AbstractLocalResourceFactory<EntityController> {
    private final EntityFactory entityFactory;

    public EntityControllerLocalResourceFactory(EntityFactory entityFactory) {
        this.entityFactory = entityFactory;
    }

    @Override
    protected EntityController createResourceObject(EnumMap<ResourceType, Object> globalObjects, ResourceRegistry registry) {
        return new EntityController(
                createEntityCreator(registry),
                createEntityPlacer(),
                createEntityDestroyer()
        );
    }

    private EntityCreator createEntityCreator(ResourceRegistry registry) {
        return new EntityCreator(entityFactory, registry.getResource(
                ResourceType.EntityPrefabStorageResource, EntityPrefabStorage.class));
    }

    private EntityPlacer createEntityPlacer() {
        return new EntityPlacer();
    }

    private EntityDestroyer createEntityDestroyer() {
        return new EntityDestroyer();
    }

    @Override
    protected ResourceDisposer<EntityController> createResourceDisposer() {
        return null;
    }

    @Override
    protected ResourceType getCreatedResourceType() {
        return ResourceType.EntityControllerResource;
    }

    @Override
    protected ResourceType[] getRequiredResources() {
        return new ResourceType[0];
    }
}
