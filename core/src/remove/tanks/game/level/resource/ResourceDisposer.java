package remove.tanks.game.level.resource;

/**
 * @author Mateusz Długosz
 */
public interface ResourceDisposer<T> {
    void disposeResource(T object);
}
