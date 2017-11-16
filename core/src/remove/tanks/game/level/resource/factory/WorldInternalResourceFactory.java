package remove.tanks.game.level.resource.factory;

import com.badlogic.gdx.physics.box2d.World;
import remove.tanks.game.constant.LevelResource;
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
                registry.getResource(LevelResource.Properties.toString(), Properties.class));
        world.setContactListener(new SensorContactListener());
        return world;
    }

    @Override
    protected String[] getRequiredResources() {
        return new String[] {
                LevelResource.Properties.toString()
        };
    }
}
