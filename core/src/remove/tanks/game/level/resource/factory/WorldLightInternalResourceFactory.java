package remove.tanks.game.level.resource.factory;

import com.badlogic.gdx.physics.box2d.World;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.resource.AbstractInternalResourceFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.physics.light.world.WorldLight;
import remove.tanks.game.physics.light.world.WorldLightFactory;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class WorldLightInternalResourceFactory
        extends AbstractInternalResourceFactory<WorldLight>
{
    private final WorldLightFactory worldLightFactory;

    public WorldLightInternalResourceFactory(WorldLightFactory worldLightFactory) {
        this.worldLightFactory = worldLightFactory;
    }

    @Override
    protected String getResourceName() {
        return LevelResource.WorldLight.toString();
    }

    @Override
    protected WorldLight getResourceObject(ResourceRegistry registry) {
        return worldLightFactory.createWorldLight(
                registry.getResource(LevelResource.World.toString(), World.class),
                registry.getResource(LevelResource.Properties.toString(), Properties.class)
        );
    }

    @Override
    protected String[] getRequiredResources() {
        return new String[] {
                LevelResource.World.toString(),
                LevelResource.Properties.toString()
        };
    }
}
