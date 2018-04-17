package remove.tanks.game.level.resource.factories;

import com.badlogic.ashley.core.Engine;
import remove.tanks.game.level.LevelPrefab;
import remove.tanks.game.level.engine.EngineFactory;
import remove.tanks.game.level.resource.AbstractLocalResourceFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;

import java.util.EnumMap;

/**
 * @author Mateusz Długosz
 */
public final class EngineLocalResourceFactory extends AbstractLocalResourceFactory<Engine> {
    private final EngineFactory engineFactory;

    public EngineLocalResourceFactory(EngineFactory engineFactory) {
        this.engineFactory = engineFactory;
    }

    @Override
    protected ResourceType getCreatedResourceType() {
        return ResourceType.EngineResource;
    }

    @Override
    protected ResourceType[] getRequiredResources() {
        return new ResourceType[] {
                ResourceType.GameCameraResource,
                ResourceType.UICameraResource,
                ResourceType.UIScaleResource,
                ResourceType.UISkinResource,
                ResourceType.TiledMapResource,
                ResourceType.TiledMapBoundaryResource,
                ResourceType.AssetStorageResource,
                ResourceType.EntityPrefabStorageResource,
                ResourceType.WorldResource,
                ResourceType.WorldLightResource,
                ResourceType.WorldScaleResource,
                ResourceType.LocaleResource,
                ResourceType.EventBusResource,
                ResourceType.InputMapperResource,
                ResourceType.PlayerProfileResource,
                ResourceType.SpriteBatchResource
        };
    }

    @Override
    protected Engine createResourceObject(EnumMap<ResourceType, Object> globalObjects, ResourceRegistry registry) {
        return engineFactory.createEngine(registry.getResource(ResourceType.LevelPrefabResource,
                LevelPrefab.class).getEnginePrefab(), registry);
    }
}
