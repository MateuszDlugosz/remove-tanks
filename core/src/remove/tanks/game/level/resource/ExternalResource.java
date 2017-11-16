package remove.tanks.game.level.resource;

/**
 * @author Mateusz Długosz
 */
public final class ExternalResource<T> extends Resource<T> {
    public ExternalResource(String name, T object) {
        super(name, object);
    }
}
