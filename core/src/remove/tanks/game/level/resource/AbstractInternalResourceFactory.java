package remove.tanks.game.level.resource;

/**
 * @author Mateusz Długosz
 */
public abstract class AbstractInternalResourceFactory<T> extends AbstractResourceFactory {
    public final Resource<T> createResource(ResourceRegistry registry) {
        checkRequirements(registry);
        return new InternalResource<>(getResourceName(), getResourceObject(registry));
    }

    protected abstract String getResourceName();
    protected abstract T getResourceObject(ResourceRegistry registry);
}
