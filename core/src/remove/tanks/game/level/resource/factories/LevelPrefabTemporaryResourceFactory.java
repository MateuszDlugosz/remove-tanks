package remove.tanks.game.level.resource.factories;

import remove.tanks.game.level.LevelPrefab;
import remove.tanks.game.level.resource.AbstractTemporaryResourceFactory;
import remove.tanks.game.level.resource.ResourceDisposer;
import remove.tanks.game.level.resource.ResourceType;

import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class LevelPrefabTemporaryResourceFactory extends AbstractTemporaryResourceFactory<LevelPrefab> {
    @Override
    protected ResourceType getCreatedResourceType() {
        return ResourceType.LevelPrefabResource;
    }

    @Override
    protected ResourceType[] getRequiredResources() {
        return new ResourceType[0];
    }

    @Override
    protected LevelPrefab extractResourceObject(Map<ResourceType, Object> globalObjects) {
        return (LevelPrefab) globalObjects.get(ResourceType.LevelPrefabResource);
    }

    @Override
    protected ResourceDisposer<LevelPrefab> createResourceDisposer() {
        return null;
    }
}
