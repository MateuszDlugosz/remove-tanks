package remove.tanks.game.physics.world;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class WorldFactory {
    public static final String GRAVITY_X_PROPERTY = "world.gravity.x";
    public static final String GRAVITY_Y_PROPERTY = "world.gravity.y";
    public static final String ALLOW_SLEEP_PROPERTY = "world.allow.sleep";
    public static final float GRAVITY_X_DEFAULT_VALUE = 0f;
    public static final float GRAVITY_Y_DEFAULT_VALUE = 0f;
    public static final boolean ALLOW_SLEEP_DEFAULT_VALUE = true;

    public World createWorld() {
        return createWorld(new Properties());
    }

    public World createWorld(Properties properties) {
        try {
            return new World(
                    createWorldGravity(properties),
                    properties.getBoolean(ALLOW_SLEEP_PROPERTY, ALLOW_SLEEP_DEFAULT_VALUE)
            );
        } catch (Exception e) {
            throw new WorldCreateException(e);
        }
    }

    private Vector2 createWorldGravity(Properties properties) {
        return new Vector2(
                properties.getFloat(GRAVITY_X_PROPERTY, GRAVITY_X_DEFAULT_VALUE),
                properties.getFloat(GRAVITY_Y_PROPERTY, GRAVITY_Y_DEFAULT_VALUE)
        );
    }
}
