package remove.tanks.game.level.resource;

import java.util.Arrays;

/**
 * @author Mateusz Długosz
 */
public abstract class AbstractResourceFactory {
    final void checkRequirements(ResourceRegistry registry) {
        Arrays.stream(getRequiredResources()).forEach(r -> {
            if (!registry.hasResource(r)) {
                throw new ResourceNotFoundException(r);
            }
        });
    }

    protected abstract String[] getRequiredResources();
}
