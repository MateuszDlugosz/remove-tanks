package remove.tanks.game.level.resource;

/**
 * @author Mateusz Długosz
 */
public abstract class Resource<T> {
    private final String name;
    private final T object;

    public Resource(String name, T object) {
        this.name = name;
        this.object = object;
    }

    public String getName() {
        return name;
    }

    public T getObject() {
        return object;
    }
}
