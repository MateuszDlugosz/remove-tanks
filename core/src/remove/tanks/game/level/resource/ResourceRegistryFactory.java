package remove.tanks.game.level.resource;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class ResourceRegistryFactory {
    private final Map<ResourceType, AbstractResourceFactory> resourceFactories = new EnumMap<>(ResourceType.class);

    public ResourceRegistryFactory(AbstractResourceFactory[] factories) {
        Arrays.stream(factories).forEach(f -> resourceFactories.put(f.getCreatedResourceType(), f));
    }

    public ResourceRegistry createResourceRegistry(EnumMap<ResourceType, Object> globalObjects) {
        try {
            ResourceRegistry registry = new ResourceRegistry();
            createResources(globalObjects, registry);
            registry.unregisterTemporaryResources();
            return registry;
        } catch (Exception e) {
            throw new ResourceRegistryCreateException(e);
        }
    }

    private void createResources(EnumMap<ResourceType, Object> globalObjects, ResourceRegistry registry) {
        Arrays.stream(ResourceType.values()).forEach(r -> {
            if (!resourceFactories.containsKey(r)) {
                throw new ResourceFactoryNotFoundException(r);
            }
            Resource resource = resourceFactories.get(r).createResource(globalObjects, registry);
            registry.registerResource(resource);
        });
    }
}
