package remove.tanks.game.physics.light.world;

import com.badlogic.gdx.math.MathUtils;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class WorldLightPropertyTranslator {
    private static final float MIN_COLOR_VALUE = 0f;
    private static final float MAX_COLOR_VALUE = 255f;

    public void translatePropertiesToWorldLight(WorldLight worldLight, Properties properties) {
        try {
            translateAmbientLight(worldLight, properties);
            translateShadows(worldLight, properties);
        } catch (Exception e) {
            throw new WorldLightPropertyTranslateException(properties, e);
        }
    }

    private void translateAmbientLight(WorldLight worldLight, Properties properties) {
        worldLight.setAmbientLight(
                prepareColorValue(properties.getFloat(
                        WorldLightProperty.WorldLightAmbientLightR.getName(),
                        Float.valueOf(WorldLightProperty.WorldLightAmbientLightR.getDefaultValue())
                )),
                prepareColorValue(properties.getFloat(
                        WorldLightProperty.WorldLightAmbientLightG.getName(),
                        Float.valueOf(WorldLightProperty.WorldLightAmbientLightG.getDefaultValue())
                )),
                prepareColorValue(properties.getFloat(
                        WorldLightProperty.WorldLightAmbientLightB.getName(),
                        Float.valueOf(WorldLightProperty.WorldLightAmbientLightB.getDefaultValue())
                )),
                prepareColorValue(properties.getFloat(
                        WorldLightProperty.WorldLightAmbientLightA.getName(),
                        Float.valueOf(WorldLightProperty.WorldLightAmbientLightA.getDefaultValue())
                ))
        );
    }

    private float prepareColorValue(float value) {
        return MathUtils.clamp(value, MIN_COLOR_VALUE, MAX_COLOR_VALUE) / MAX_COLOR_VALUE;
    }

    private void translateShadows(WorldLight worldLight, Properties properties) {
        worldLight.setShadows(
                properties.getBoolean(
                        WorldLightProperty.WorldLightShadows.getName(),
                        Boolean.valueOf(WorldLightProperty.WorldLightShadows.getDefaultValue())
                )
        );
    }
}
