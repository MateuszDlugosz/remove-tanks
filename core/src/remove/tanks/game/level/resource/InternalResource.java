package remove.tanks.game.level.resource;

/**
 * @author Mateusz Długosz
 */
public final class InternalResource<T> extends Resource<T> {
    public InternalResource(String name, T object) {
        super(name, object);
    }
}
