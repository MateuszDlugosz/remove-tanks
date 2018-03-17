package remove.tanks.game.level.resource;

import java.util.EnumMap;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class ResourceRegistry {
    private final Map<ResourceType, Resource> resources = new EnumMap<>(ResourceType.class);

    void registerResource(Resource resource) {
        if (hasResource(resource.getResourceType())) {
            throw new ResourceAlreadyExistsException(resource.getResourceType());
        }
        resources.put(resource.getResourceType(), resource);
    }

    void unregisterTemporaryResources() {
        resources.keySet().forEach(r -> {
            if (resources.get(r) instanceof TemporaryResource) {
                resources.remove(r);
            }
        });
    }

    @SuppressWarnings("unchecked")
    public <T> T getResource(ResourceType resourceType, Class<T> resourceClass) {
        if (!hasResource(resourceType)) {
            throw new ResourceNotFoundException(resourceType);
        }
        if (!resourceClass.isAssignableFrom(resources.get(resourceType).getObject().getClass())) {
            throw new ResourceIncompatibleTypeException(resources.get(resourceType).getObject().getClass(), resourceClass);
        }
        return (T) resources.get(resourceType).getObject();
    }

    public Object getResource(ResourceType resourceType) {
        if (!hasResource(resourceType)) {
            throw new ResourceNotFoundException(resourceType);
        }
        return resources.get(resourceType).getObject();
    }

    public boolean hasResource(ResourceType resourceType) {
        return resources.containsKey(resourceType);
    }

    public void dispose() {
        resources.values().forEach(r -> {
            if (r instanceof DisposableResource) {
                ((DisposableResource) r).disposeResource();
            }
        });
    }
}
