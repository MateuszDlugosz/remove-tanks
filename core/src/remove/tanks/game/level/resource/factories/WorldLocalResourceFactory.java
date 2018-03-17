package remove.tanks.game.level.resource.factories;

import com.badlogic.gdx.physics.box2d.World;
import remove.tanks.game.level.LevelPrefab;
import remove.tanks.game.level.engine.contact.SensorContactListener;
import remove.tanks.game.level.resource.AbstractLocalResourceFactory;
import remove.tanks.game.level.resource.ResourceDisposer;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.physics.world.WorldFactory;
import remove.tanks.game.physics.world.WorldPropertyTranslator;

import java.util.EnumMap;

/**
 * @author Mateusz Długosz
 */
public final class WorldLocalResourceFactory extends AbstractLocalResourceFactory<World> {
    private final WorldFactory worldFactory;
    private final WorldPropertyTranslator worldPropertyTranslator;

    public WorldLocalResourceFactory(WorldFactory worldFactory, WorldPropertyTranslator worldPropertyTranslator) {
        this.worldFactory = worldFactory;
        this.worldPropertyTranslator = worldPropertyTranslator;
    }

    @Override
    protected ResourceType getCreatedResourceType() {
        return ResourceType.WorldResource;
    }

    @Override
    protected ResourceType[] getRequiredResources() {
        return new ResourceType[0];
    }

    @Override
    protected World createResourceObject(EnumMap<ResourceType, Object> globalObjects, ResourceRegistry registry) {
        World world = worldFactory.createWorld();
        world.setContactListener(new SensorContactListener());

        registry.getResource(ResourceType.LevelPrefabResource, LevelPrefab.class).getResourceConfigurations()
                .getProperties(ResourceType.WorldResource)
                .ifPresent(p -> worldPropertyTranslator.translatePropertiesToWorld(world, p));

        return world;
    }

    @Override
    protected ResourceDisposer<World> createResourceDisposer() {
        return World::dispose;
    }
}
