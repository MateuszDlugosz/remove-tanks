package remove.tanks.game.level.resource;

import java.util.Arrays;
import java.util.EnumMap;

/**
 * @author Mateusz Długosz
 */
public abstract class AbstractResourceFactory<T> {
    protected final void checkResourceRequirements(ResourceRegistry registry) {
        Arrays.stream(getRequiredResources()).forEach(r -> {
            if (!registry.hasResource(r)) {
                throw new ResourceRequirementsException(r);
            }
        });
    }

    public abstract Resource<T> createResource(EnumMap<ResourceType, Object> globalObjects, ResourceRegistry registry);
    protected abstract ResourceType getCreatedResourceType();
    protected abstract ResourceType[] getRequiredResources();
}
