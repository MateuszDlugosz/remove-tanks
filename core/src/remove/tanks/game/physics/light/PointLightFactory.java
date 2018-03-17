package remove.tanks.game.physics.light;

import box2dLight.PointLight;
import com.badlogic.gdx.physics.box2d.Body;
import remove.tanks.game.graphics.color.ColorFactory;
import remove.tanks.game.physics.light.world.WorldLight;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class PointLightFactory implements SubLightFactory<PointLight, PointLightPrefab> {
    private final ColorFactory colorFactory;

    public PointLightFactory(ColorFactory colorFactory) {
        this.colorFactory = colorFactory;
    }

    @Override
    public PointLight createLight(PointLightPrefab prefab, WorldLight worldLight, Scale scale) {
        try {
            PointLight light = new PointLight(
                    worldLight,
                    worldLight.getNumberOfRays(),
                    colorFactory.createColor(prefab.getColorPrefab()),
                    scale.scaleValue(prefab.getDistance()),
                    scale.scaleValue(prefab.getPositionPrefab().getX()),
                    scale.scaleValue(prefab.getPositionPrefab().getY())
            );
            light.setXray(prefab.getXRay());
            return light;
        } catch (Exception e) {
            throw new LightCreateException(prefab, e);
        }
    }

    @Override
    public PointLight createLight(PointLightPrefab prefab, WorldLight worldLight, Body body, Scale scale) {
        try {
            PointLight light = new PointLight(
                    worldLight,
                    worldLight.getNumberOfRays(),
                    colorFactory.createColor(prefab.getColorPrefab()),
                    scale.scaleValue(prefab.getDistance()),
                    0,
                    0
            );
            light.attachToBody(
                    body,
                    scale.scaleValue(prefab.getPositionPrefab().getX()),
                    scale.scaleValue(prefab.getPositionPrefab().getY())
            );
            light.setXray(prefab.getXRay());
            return light;
        } catch (Exception e) {
            throw new LightCreateException(prefab, e);
        }
    }

    @Override
    public Class<PointLightPrefab> getFactoryType() {
        return PointLightPrefab.class;
    }
}
