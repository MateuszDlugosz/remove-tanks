package remove.tanks.game.level.resource.factories;

import com.badlogic.gdx.Gdx;
import remove.tanks.game.level.LevelPrefab;
import remove.tanks.game.level.engine.entity.EntityPrefabRepositoryXmlReader;
import remove.tanks.game.level.engine.entity.EntityPrefabStorage;
import remove.tanks.game.level.engine.entity.EntityPrefabStorageFactory;
import remove.tanks.game.level.resource.AbstractLocalResourceFactory;
import remove.tanks.game.level.resource.ResourceDisposer;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

import java.util.EnumMap;
import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class EntityPrefabStorageLocalResourceFactory extends AbstractLocalResourceFactory<EntityPrefabStorage> {
    private final EntityPrefabRepositoryXmlReader entityPrefabRepositoryXmlReader;
    private final EntityPrefabStorageFactory entityPrefabStorageFactory;

    public EntityPrefabStorageLocalResourceFactory(
            EntityPrefabRepositoryXmlReader entityPrefabRepositoryXmlReader,
            EntityPrefabStorageFactory entityPrefabStorageFactory
    ) {
        this.entityPrefabRepositoryXmlReader = entityPrefabRepositoryXmlReader;
        this.entityPrefabStorageFactory = entityPrefabStorageFactory;
    }

    @Override
    protected EntityPrefabStorage createResourceObject(EnumMap<ResourceType, Object> globalObjects, ResourceRegistry registry) {
        EntityPrefabStorage entityPrefabStorage = entityPrefabStorageFactory.createEntityPrefabStorage(
                entityPrefabRepositoryXmlReader.readEntityPrefabFilenameRepository(
                        Gdx.files.internal(
                                registry.getResource(ResourceType.LevelPrefabResource, LevelPrefab.class)
                                        .getEntityPrefabRepositoryFilename()
                        )
                )
        );
        loadEntityPrefabs(entityPrefabStorage, registry.getResource(ResourceType.LevelPrefabResource, LevelPrefab.class)
                .getPreloadData().getEntityPrefabCodes());
        return entityPrefabStorage;
    }

    private void loadEntityPrefabs(EntityPrefabStorage storage, List<String> prefabCodes) {
        prefabCodes.forEach(code -> {
            if (!storage.isEntityPrefabLoaded(code)) {
                storage.loadEntityPrefab(code);
                loadEntityPrefabs(storage, storage.getEntityPrefab(code).getPreloadData().getEntityPrefabCodes());
            }
        });
    }

    @Override
    protected ResourceDisposer<EntityPrefabStorage> createResourceDisposer() {
        return EntityPrefabStorage::unloadAllEntityPrefabs;
    }

    @Override
    protected ResourceType getCreatedResourceType() {
        return ResourceType.EntityPrefabStorageResource;
    }

    @Override
    protected ResourceType[] getRequiredResources() {
        return new ResourceType[] {
                ResourceType.LevelPrefabResource
        };
    }
}
