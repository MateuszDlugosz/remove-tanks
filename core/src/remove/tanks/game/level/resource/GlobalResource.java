package remove.tanks.game.level.resource;

/**
 * @author Mateusz Długosz
 */
public final class GlobalResource<T> extends Resource<T> {
    public GlobalResource(ResourceType resourceType, T object) {
        super(resourceType, object);
    }
}
