package remove.tanks.game.level.resource;

import java.util.EnumMap;

/**
 * @author Mateusz Długosz
 */
public abstract class AbstractGlobalResourceFactory<T> extends AbstractResourceFactory<T> {
    @Override
    public final Resource<T> createResource(EnumMap<ResourceType, Object> globalObjects, ResourceRegistry registry) {
        try {
            checkResourceRequirements(registry);
            return new GlobalResource<>(
                    getCreatedResourceType(),
                    extractResourceObject(globalObjects)
            );
        } catch (Exception e) {
            throw new ResourceCreateException(getCreatedResourceType(), e);
        }
    }

    @SuppressWarnings("unchecked")
    protected final T extractResourceObject(EnumMap<ResourceType, Object> globalObjects) {
        if (!globalObjects.containsKey(getCreatedResourceType())) {
            throw new GlobalResourceObjectNotFoundException(getCreatedResourceType());
        }
        if (!getCreatedResourceType().getResourceClass()
                .isAssignableFrom(globalObjects.get(getCreatedResourceType()).getClass()))
        {
            throw new IncompatibleResourceObjectClassException(globalObjects.get(getCreatedResourceType()).getClass(),
                    getCreatedResourceType().getResourceClass());
        }
        return prepareResourceObject((T) globalObjects.get(getCreatedResourceType()));
    }

    protected abstract T prepareResourceObject(T object);
}
