package remove.tanks.game.level.resource;

import com.badlogic.gdx.utils.Disposable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class ResourceRegistry implements Disposable {
    private final Map<String, Resource> resources = new HashMap<>();

    ResourceRegistry() {}

    void registerResource(Resource resource) {
        if (resources.containsKey(resource.getName())) {
            throw new ResourceAlreadyExistsException(resource.getName());
        }
        resources.put(resource.getName(), resource);
    }

    public Object getResource(String name) {
        if (!resources.containsKey(name)) {
            throw new ResourceNotFoundException(name);
        }
        return resources.get(name);
    }

    @SuppressWarnings("unchecked")
    public <T> T getResource(String name, Class<T> type) {
        if (!resources.containsKey(name)) {
            throw new ResourceNotFoundException(name);
        }
        return (T) resources.get(name).getObject();
    }

    public boolean hasResource(String name) {
        return resources.containsKey(name);
    }

    @Override
    public void dispose() {
        for (Resource resource : resources.values()) {
            if (resource instanceof InternalResource) {
                if (resource.getObject() instanceof Disposable) {
                    ((Disposable) resource.getObject()).dispose();
                }
            }
        }
    }
}
