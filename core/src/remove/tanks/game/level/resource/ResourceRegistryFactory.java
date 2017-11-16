package remove.tanks.game.level.resource;

import java.util.*;

/**
 * @author Mateusz Długosz
 */
public final class ResourceRegistryFactory {
    private final Map<String, AbstractExternalResourceFactory> externalFactories
            = new HashMap<>();
    private final List<AbstractInternalResourceFactory> internalFactories
            = new ArrayList<>();

    public ResourceRegistryFactory(
            AbstractExternalResourceFactory[] externalFactories,
            AbstractInternalResourceFactory[] internalFactories
    ) {
        Arrays.stream(externalFactories).forEach(f -> this.externalFactories.put(f.getResourceName(), f));
        this.internalFactories.addAll(Arrays.asList(internalFactories));
    }

    public ResourceRegistry createResourceRegistry(Map<String, Object> externalObjects) {
        ResourceRegistry registry = new ResourceRegistry();
        createExternalResources(registry, externalObjects);
        createInternalResources(registry);
        return registry;
    }

    private void createExternalResources(ResourceRegistry registry, Map<String, Object> externalObjects) {
        externalObjects.forEach((k, v) -> {
            if (!externalFactories.containsKey(k)) {
                throw new ExternalResourceFactoryNotFoundException(k, v.getClass());
            } else {
                registry.registerResource(externalFactories.get(k).createResource(v, registry));
            }
        });
    }

    private void createInternalResources(ResourceRegistry registry) {
        internalFactories.forEach(f -> registry.registerResource(f.createResource(registry)));
    }
}
