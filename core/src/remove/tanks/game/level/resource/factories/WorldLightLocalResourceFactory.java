package remove.tanks.game.level.resource.factories;

import box2dLight.RayHandler;
import com.badlogic.gdx.physics.box2d.World;
import remove.tanks.game.level.LevelPrefab;
import remove.tanks.game.level.resource.AbstractLocalResourceFactory;
import remove.tanks.game.level.resource.ResourceDisposer;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.physics.light.world.WorldLight;
import remove.tanks.game.physics.light.world.WorldLightFactory;
import remove.tanks.game.physics.light.world.WorldLightPropertyTranslator;

import java.util.EnumMap;

/**
 * @author Mateusz Długosz
 */
public final class WorldLightLocalResourceFactory extends AbstractLocalResourceFactory<WorldLight> {
    private final WorldLightFactory worldLightFactory;
    private final WorldLightPropertyTranslator worldLightPropertyTranslator;

    public WorldLightLocalResourceFactory(
            WorldLightFactory worldLightFactory,
            WorldLightPropertyTranslator worldLightPropertyTranslator
    ) {
        this.worldLightFactory = worldLightFactory;
        this.worldLightPropertyTranslator = worldLightPropertyTranslator;
    }

    @Override
    protected ResourceType getCreatedResourceType() {
        return ResourceType.WorldLightResource;
    }

    @Override
    protected ResourceType[] getRequiredResources() {
        return new ResourceType[] {
                ResourceType.WorldResource
        };
    }

    @Override
    protected WorldLight createResourceObject(EnumMap<ResourceType, Object> globalObjects, ResourceRegistry registry) {
        WorldLight worldLight = worldLightFactory.createWorldLight(
                registry.getResource(ResourceType.WorldResource, World.class));

        registry.getResource(ResourceType.LevelPrefabResource, LevelPrefab.class).getResourceConfigurations()
                .getProperties(ResourceType.WorldLightResource)
                .ifPresent(p -> worldLightPropertyTranslator.translatePropertiesToWorldLight(worldLight, p));

        return worldLight;
    }

    @Override
    protected ResourceDisposer<WorldLight> createResourceDisposer() {
        return RayHandler::dispose;
    }
}
