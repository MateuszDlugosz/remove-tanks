package remove.tanks.game.level;

import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class Level {
    private final ResourceRegistry resourceRegistry;

    public Level(ResourceRegistry resourceRegistry) {
        this.resourceRegistry = resourceRegistry;
    }

    public ResourceRegistry getResourceRegistry() {
        return resourceRegistry;
    }
}
