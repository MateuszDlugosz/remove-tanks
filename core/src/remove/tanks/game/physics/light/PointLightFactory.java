package remove.tanks.game.physics.light;

import box2dLight.PointLight;
import com.badlogic.gdx.physics.box2d.Body;
import remove.tanks.game.graphic.color.ColorFactory;
import remove.tanks.game.physics.light.world.WorldLight;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class PointLightFactory implements RegistrableLightFactory<PointLight, PointLightPrototype> {
    private final ColorFactory colorFactory;

    public PointLightFactory(ColorFactory colorFactory) {
        this.colorFactory = colorFactory;
    }


    @Override
    public PointLight createLight(PointLightPrototype prototype, WorldLight worldLight, Scale scale) {
        try {
            PointLight light = new PointLight(
                    worldLight,
                    worldLight.getNumberOfRays(),
                    colorFactory.createColor(prototype.getColorPrototype()),
                    scale.scaleValue(prototype.getDistance()),
                    scale.scaleValue(prototype.getPositionPrototype().getX()),
                    scale.scaleValue(prototype.getPositionPrototype().getY())
            );
            light.setXray(prototype.getXRay());
            return light;
        } catch (Exception e) {
            throw new LightCreateException(prototype, e);
        }
    }

    @Override
    public PointLight createLight(PointLightPrototype prototype, WorldLight worldLight, Body body, Scale scale) {
        try {
            PointLight light = new PointLight(
                    worldLight,
                    worldLight.getNumberOfRays(),
                    colorFactory.createColor(prototype.getColorPrototype()),
                    scale.scaleValue(prototype.getDistance()),
                    0,
                    0
            );
            light.attachToBody(
                    body,
                    scale.scaleValue(prototype.getPositionPrototype().getX()),
                    scale.scaleValue(prototype.getPositionPrototype().getY())
            );
            light.setXray(prototype.getXRay());
            return light;
        } catch (Exception e) {
            throw new LightCreateException(prototype, e);
        }
    }

    @Override
    public Class<PointLightPrototype> getFactoryType() {
        return PointLightPrototype.class;
    }
}
