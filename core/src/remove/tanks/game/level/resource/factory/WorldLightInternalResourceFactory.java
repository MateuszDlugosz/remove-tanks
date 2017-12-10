package remove.tanks.game.level.resource.factory;

import com.badlogic.gdx.physics.box2d.World;
import remove.tanks.game.level.constant.LevelProperty;
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

    private Properties createProperties(Properties properties) {
        Properties resourceProperties = new Properties();
        resourceProperties.putInt(
                WorldLightFactory.NUMBER_OF_RAYS_PROPERTY,
                properties.getInt(LevelProperty.LevelResourceWorldLightNumberOfRays.getName(),
                        WorldLightFactory.NUMBER_OF_RAYS_PROPERTY_DEFAULT_VALUE)
        );
        resourceProperties.putFloat(
                WorldLightFactory.AMBIENT_LIGHT_R_PROPERTY,
                properties.getFloat(LevelProperty.LevelResourceWorldLightAmbientR.getName(),
                        WorldLightFactory.AMBIENT_LIGHT_R_DEFAULT_VALUE)
        );
        resourceProperties.putFloat(
                WorldLightFactory.AMBIENT_LIGHT_G_PROPERTY,
                properties.getFloat(LevelProperty.LevelResourceWorldLightAmbientG.getName(),
                        WorldLightFactory.AMBIENT_LIGHT_G_DEFAULT_VALUE)
        );
        resourceProperties.putFloat(
                WorldLightFactory.AMBIENT_LIGHT_B_PROPERTY,
                properties.getFloat(LevelProperty.LevelResourceWorldLightAmbientB.getName(),
                        WorldLightFactory.AMBIENT_LIGHT_B_DEFAULT_VALUE)
        );
        resourceProperties.putFloat(
                WorldLightFactory.AMBIENT_LIGHT_A_PROPERTY,
                properties.getFloat(LevelProperty.LevelResourceWorldLightAmbientA.getName(),
                        WorldLightFactory.AMBIENT_LIGHT_A_DEFAULT_VALUE)
        );
        return resourceProperties;
    }

    @Override
    protected String[] getRequiredResources() {
        return new String[] {
                LevelResource.World.toString(),
                LevelResource.Properties.toString()
        };
    }
}
