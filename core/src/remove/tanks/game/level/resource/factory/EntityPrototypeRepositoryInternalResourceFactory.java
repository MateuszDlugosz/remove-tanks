package remove.tanks.game.level.resource.factory;

import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.entity.EntityPrototypeRepository;
import remove.tanks.game.level.engine.entity.EntityPrototypeRepositoryXmlLoader;
import remove.tanks.game.level.resource.AbstractInternalResourceFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class EntityPrototypeRepositoryInternalResourceFactory
        extends AbstractInternalResourceFactory<EntityPrototypeRepository>
{
    public static final String ENTITY_PROTOTYPE_REPOSITORY_FILENAME_PROPERTY
            = "entity.prototype.repository.filename";

    private final EntityPrototypeRepositoryXmlLoader entityPrototypeRepositoryXmlLoader;

    public EntityPrototypeRepositoryInternalResourceFactory(
            EntityPrototypeRepositoryXmlLoader entityPrototypeRepositoryXmlLoader
    ) {
        this.entityPrototypeRepositoryXmlLoader = entityPrototypeRepositoryXmlLoader;
    }

    @Override
    protected String getResourceName() {
        return LevelResource.EntityPrototypeRepository.toString();
    }

    @Override
    protected EntityPrototypeRepository getResourceObject(ResourceRegistry registry) {
        return entityPrototypeRepositoryXmlLoader.loadPrototypeRepository(
                registry.getResource(LevelResource.Properties.toString(), Properties.class)
                        .getString(ENTITY_PROTOTYPE_REPOSITORY_FILENAME_PROPERTY)
        );
    }

    @Override
    protected String[] getRequiredResources() {
        return new String[] {
                LevelResource.Properties.toString()
        };
    }
}
