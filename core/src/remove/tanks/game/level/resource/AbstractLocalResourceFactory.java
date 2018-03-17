package remove.tanks.game.level.resource;

import java.util.EnumMap;

/**
 * @author Mateusz Długosz
 */
public abstract class AbstractLocalResourceFactory<T> extends AbstractResourceFactory<T> {
    @Override
    public final Resource<T> createResource(EnumMap<ResourceType, Object> globalObjects, ResourceRegistry registry) {
        try {
            checkResourceRequirements(registry);
            return new LocalResource<>(
                    getCreatedResourceType(),
                    createResourceObject(globalObjects, registry),
                    createResourceDisposer()
            );
        } catch (Exception e) {
            throw new ResourceCreateException(getCreatedResourceType(), e);
        }
    }

    protected abstract T createResourceObject(EnumMap<ResourceType, Object> globalObjects, ResourceRegistry registry);
    protected abstract ResourceDisposer<T> createResourceDisposer();
}
