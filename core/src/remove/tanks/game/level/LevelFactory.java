package remove.tanks.game.level;

import remove.tanks.game.level.resource.ResourceRegistryFactory;

import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class LevelFactory {
    private final ResourceRegistryFactory resourceRegistryFactory;

    public LevelFactory(ResourceRegistryFactory resourceRegistryFactory) {
        this.resourceRegistryFactory = resourceRegistryFactory;
    }

    public Level createLevel(Map<String, Object> resourcesObjects) {
        return new Level(resourceRegistryFactory.createResourceRegistry(resourcesObjects));
    }
}
