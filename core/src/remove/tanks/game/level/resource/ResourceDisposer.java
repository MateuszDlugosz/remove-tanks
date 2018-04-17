package remove.tanks.game.level.resource;

/**
 * @author Mateusz Długosz
 */
@FunctionalInterface
public interface ResourceDisposer<T> {
    void disposeResource(T object);
}
