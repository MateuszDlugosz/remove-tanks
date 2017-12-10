package remove.tanks.game.level.resource.factory;

import com.badlogic.gdx.physics.box2d.World;
import remove.tanks.game.level.constant.LevelProperty;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.contact.SensorContactListener;
import remove.tanks.game.level.resource.AbstractInternalResourceFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.physics.world.WorldFactory;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class WorldInternalResourceFactory
        extends AbstractInternalResourceFactory<World>
{
    private final WorldFactory worldFactory;

    public WorldInternalResourceFactory(WorldFactory worldFactory) {
        this.worldFactory = worldFactory;
    }

    @Override
    protected String getResourceName() {
        return LevelResource.World.toString();
    }

    @Override
    protected World getResourceObject(ResourceRegistry registry) {
        World world = worldFactory.createWorld(
                createProperties(
                        registry.getResource(LevelResource.Properties.toString(), Properties.class)
                )
        );
        world.setContactListener(new SensorContactListener());
        return world;
    }

    private Properties createProperties(Properties properties) {
        Properties resourceProperties = new Properties();
        resourceProperties.putFloat(
                WorldFactory.GRAVITY_X_PROPERTY,
                properties.getFloat(LevelProperty.LevelResourceWorldGravityX.getName(),
                        WorldFactory.GRAVITY_X_DEFAULT_VALUE)
        );
        resourceProperties.putFloat(
                WorldFactory.GRAVITY_Y_PROPERTY,
                properties.getFloat(LevelProperty.LevelResourceWorldGravityY.getName(),
                        WorldFactory.GRAVITY_Y_DEFAULT_VALUE)
        );
        resourceProperties.putBoolean(
                WorldFactory.ALLOW_SLEEP_PROPERTY,
                properties.getBoolean(LevelProperty.LevelResourceWorldAllowSleep.getName(),
                        WorldFactory.ALLOW_SLEEP_DEFAULT_VALUE)
        );
        return resourceProperties;
    }

    @Override
    protected String[] getRequiredResources() {
        return new String[] {
                LevelResource.Properties.toString()
        };
    }
}
