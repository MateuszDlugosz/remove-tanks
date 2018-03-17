package remove.tanks.game.physics.light;

import box2dLight.ConeLight;
import com.badlogic.gdx.physics.box2d.Body;
import remove.tanks.game.graphics.color.ColorFactory;
import remove.tanks.game.physics.light.world.WorldLight;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class ConeLightFactory implements SubLightFactory<ConeLight, ConeLightPrefab> {
    private final ColorFactory colorFactory;

    public ConeLightFactory(ColorFactory colorFactory) {
        this.colorFactory = colorFactory;
    }

    @Override
    public ConeLight createLight(ConeLightPrefab prefab, WorldLight worldLight, Scale scale) {
        try {
            ConeLight light = new ConeLight(
                    worldLight,
                    worldLight.getNumberOfRays(),
                    colorFactory.createColor(prefab.getColorPrefab()),
                    scale.scaleValue(prefab.getDistance()),
                    scale.scaleValue(prefab.getPositionPrefab().getX()),
                    scale.scaleValue(prefab.getPositionPrefab().getY()),
                    prefab.getDirectionDegree(),
                    prefab.getConeDegree()
            );
            light.setXray(prefab.getXRay());
            return light;
        } catch (Exception e) {
            throw new LightCreateException(prefab, e);
        }
    }

    @Override
    public ConeLight createLight(ConeLightPrefab prefab, WorldLight worldLight, Body body, Scale scale) {
        try {
            ConeLight light = new ConeLight(
                    worldLight,
                    worldLight.getNumberOfRays(),
                    colorFactory.createColor(prefab.getColorPrefab()),
                    scale.scaleValue(prefab.getDistance()),
                    0,
                    0,
                    prefab.getDirectionDegree(),
                    prefab.getConeDegree()
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
    public Class<ConeLightPrefab> getFactoryType() {
        return ConeLightPrefab.class;
    }
}
