package remove.tanks.game.level.resource;

import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public final class GlobalResource<T> extends Resource<T> implements DisposableResource {
    private final ResourceDisposer<T> resourceDisposer;

    public GlobalResource(ResourceType resourceType, T object, ResourceDisposer<T> resourceDisposer) {
        super(resourceType, object);
        this.resourceDisposer = resourceDisposer;
    }
    public void disposeResource() {
        Optional.ofNullable(resourceDisposer).ifPresent(d -> d.disposeResource(getObject()));
    }
}
