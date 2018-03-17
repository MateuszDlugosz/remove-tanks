package remove.tanks.game.physics.world;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class WorldPropertyTranslator {
    public void translatePropertiesToWorld(World world, Properties properties) {
        try {
            translateGravityProperties(world, properties);
        } catch (Exception e) {
            throw new WorldPropertyTranslateException(properties, e);
        }
    }

    private void translateGravityProperties(World world, Properties properties) {
        world.setGravity(new Vector2(
                properties.getFloat(
                        WorldProperty.WorldGravityX.getName(),
                        Float.valueOf(WorldProperty.WorldGravityX.getDefaultValue())
                ),
                properties.getFloat(
                        WorldProperty.WorldGravityY.getName(),
                        Float.valueOf(WorldProperty.WorldGravityY.getDefaultValue())
                )
        ));
    }
}
