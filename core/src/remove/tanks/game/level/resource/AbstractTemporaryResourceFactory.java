package remove.tanks.game.level.resource;

import java.util.EnumMap;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public abstract class AbstractTemporaryResourceFactory<T> extends AbstractResourceFactory<T> {
    @Override
    public final Resource<T> createResource(EnumMap<ResourceType, Object> globalObjects, ResourceRegistry registry) {
        try {
            checkResourceRequirements(registry);
            return new TemporaryResource<>(
                    getCreatedResourceType(),
                    extractResourceObject(globalObjects),
                    createResourceDisposer()
            );
        } catch (Exception e) {
            throw new ResourceCreateException(getCreatedResourceType(), e);
        }
    }

    protected abstract T extractResourceObject(Map<ResourceType, Object> globalObjects);
    protected abstract ResourceDisposer<T> createResourceDisposer();
}
