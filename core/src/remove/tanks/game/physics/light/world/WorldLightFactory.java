package remove.tanks.game.physics.light.world;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.World;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class WorldLightFactory {
    private static final String NUMBER_OF_RAYS_PROPERTY = "world.light.number.of.rays";
    private static final int NUMBER_OF_RAYS_PROPERTY_DEFAULT_VALUE = 100;
    private static final String AMBIENT_LIGHT_R_PROPERTY = "world.light.ambient.r";
    private static final float AMBIENT_LIGHT_R_DEFAULT_VALUE = 0f;
    private static final String AMBIENT_LIGHT_G_PROPERTY = "world.light.ambient.g";
    private static final float AMBIENT_LIGHT_G_DEFAULT_VALUE = 0f;
    private static final String AMBIENT_LIGHT_B_PROPERTY = "world.light.ambient.b";
    private static final float AMBIENT_LIGHT_B_DEFAULT_VALUE = 0f;
    private static final String AMBIENT_LIGHT_A_PROPERTY = "world.light.ambient.a";
    private static final float AMBIENT_LIGHT_A_DEFAULT_VALUE = 0.5f;
    private static final float AMBIENT_LIGHT_COLOR_MIN_VALUE = 0f;
    private static final float AMBIENT_LIGHT_COLOR_MAX_VALUE = 255f;

    public WorldLight createWorldLight(World world) {
        return createWorldLight(world, new Properties());
    }

    public WorldLight createWorldLight(World world, Properties properties) {
        try {
            WorldLight worldLight = new WorldLight(world, properties.getInt(
                    NUMBER_OF_RAYS_PROPERTY,
                    NUMBER_OF_RAYS_PROPERTY_DEFAULT_VALUE
            ));
            worldLight.setAmbientLight(
                    prepareColorValue(properties.getFloat(
                            AMBIENT_LIGHT_R_PROPERTY,
                            AMBIENT_LIGHT_R_DEFAULT_VALUE
                    )),
                    prepareColorValue(properties.getFloat(
                            AMBIENT_LIGHT_G_PROPERTY,
                            AMBIENT_LIGHT_G_DEFAULT_VALUE
                    )),
                    prepareColorValue(properties.getFloat(
                            AMBIENT_LIGHT_B_PROPERTY,
                            AMBIENT_LIGHT_B_DEFAULT_VALUE
                    )),
                    prepareColorValue(properties.getFloat(
                            AMBIENT_LIGHT_A_PROPERTY,
                            AMBIENT_LIGHT_A_DEFAULT_VALUE
                    ))
            );
            return worldLight;
        } catch (Exception e) {
            throw new WorldLightCreateException(e);
        }
    }

    private float prepareColorValue(float value) {
        return MathUtils.clamp(value, AMBIENT_LIGHT_COLOR_MIN_VALUE, AMBIENT_LIGHT_COLOR_MAX_VALUE)
                / AMBIENT_LIGHT_COLOR_MAX_VALUE;
    }
}
