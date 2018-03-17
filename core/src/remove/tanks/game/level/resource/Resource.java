package remove.tanks.game.level.resource;

/**
 * @author Mateusz Długosz
 */
public abstract class Resource<T> {
    private final ResourceType resourceType;
    private final T object;

    public Resource(ResourceType resourceType, T object) {
        this.resourceType = resourceType;
        this.object = object;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public T getObject() {
        return object;
    }
}
