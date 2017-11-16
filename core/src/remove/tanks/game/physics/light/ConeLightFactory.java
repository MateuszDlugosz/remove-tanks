package remove.tanks.game.physics.light;

import box2dLight.ConeLight;
import com.badlogic.gdx.physics.box2d.Body;
import remove.tanks.game.graphic.color.ColorFactory;
import remove.tanks.game.physics.light.world.WorldLight;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class ConeLightFactory implements RegistrableLightFactory<ConeLight, ConeLightPrototype> {
    private final ColorFactory colorFactory;

    public ConeLightFactory(ColorFactory colorFactory) {
        this.colorFactory = colorFactory;
    }

    @Override
    public ConeLight createLight(ConeLightPrototype prototype, WorldLight worldLight, Scale scale) {
        try {
            ConeLight light = new ConeLight(
                    worldLight,
                    worldLight.getNumberOfRays(),
                    colorFactory.createColor(prototype.getColorPrototype()),
                    scale.scaleValue(prototype.getDistance()),
                    scale.scaleValue(prototype.getPositionPrototype().getX()),
                    scale.scaleValue(prototype.getPositionPrototype().getY()),
                    prototype.getDirectionDegree(),
                    prototype.getConeDegree()
            );
            light.setXray(prototype.getXRay());
            return light;
        } catch (Exception e) {
            throw new LightCreateException(prototype, e);
        }
    }

    @Override
    public ConeLight createLight(ConeLightPrototype prototype, WorldLight worldLight, Body body, Scale scale) {
        try {
            ConeLight light = new ConeLight(
                    worldLight,
                    worldLight.getNumberOfRays(),
                    colorFactory.createColor(prototype.getColorPrototype()),
                    scale.scaleValue(prototype.getDistance()),
                    0,
                    0,
                    prototype.getDirectionDegree(),
                    prototype.getConeDegree()
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
    public Class<ConeLightPrototype> getFactoryType() {
        return ConeLightPrototype.class;
    }
}
