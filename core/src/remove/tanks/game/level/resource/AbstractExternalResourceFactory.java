package remove.tanks.game.level.resource;

/**
 * @author Mateusz Długosz
 */
public abstract class AbstractExternalResourceFactory<T> extends AbstractResourceFactory {
    public final Resource<T> createResource(T object, ResourceRegistry registry) {
        checkRequirements(registry);
        return new ExternalResource<>(getResourceName(), prepareResourceObject(object, registry));
    }

    public abstract String getResourceName();
    public abstract T prepareResourceObject(T object, ResourceRegistry registry);
}
