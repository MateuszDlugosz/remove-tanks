package remove.tanks.game.level;

import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceRegistryFactory;
import remove.tanks.game.level.resource.ResourceType;

import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class LevelFactory {
    private final EnumMap<ResourceType, Object> externalObjects;
    private final ResourceRegistryFactory resourceRegistryFactory;

    public LevelFactory(EnumMap<ResourceType, Object> externalObjects, ResourceRegistryFactory resourceRegistryFactory) {
        this.externalObjects = externalObjects;
        this.resourceRegistryFactory = resourceRegistryFactory;
    }

    public List<Level> createLevels(List<LevelPrefab> prefabs) {
        return prefabs.stream()
                .map(this::createLevel)
                .collect(Collectors.toList());
    }

    public Level createLevel(LevelPrefab prefab) {
        try {
            return new Level(createResourceRegistry(prepareObjects(prefab)));
        } catch (Exception e) {
            throw new LevelCreateException(prefab, e);
        }
    }

    private EnumMap<ResourceType, Object> prepareObjects(LevelPrefab prefab) {
        EnumMap<ResourceType, Object> objects = new EnumMap<>(externalObjects);
        objects.put(ResourceType.LevelPrefabResource, prefab);
        return objects;
    }

    private ResourceRegistry createResourceRegistry(EnumMap<ResourceType, Object> externalObjects) {
        return resourceRegistryFactory.createResourceRegistry(externalObjects);
    }
}
