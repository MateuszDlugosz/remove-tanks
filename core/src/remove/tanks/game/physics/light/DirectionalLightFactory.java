package remove.tanks.game.physics.light;

import box2dLight.DirectionalLight;
import com.badlogic.gdx.physics.box2d.Body;
import remove.tanks.game.graphic.color.ColorFactory;
import remove.tanks.game.physics.light.world.WorldLight;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class DirectionalLightFactory implements RegistrableLightFactory<DirectionalLight, DirectionalLightPrototype> {
    private final ColorFactory colorFactory;

    public DirectionalLightFactory(ColorFactory colorFactory) {
        this.colorFactory = colorFactory;
    }

    @Override
    public DirectionalLight createLight(DirectionalLightPrototype prototype, WorldLight worldLight, Scale scale) {
        try {
            DirectionalLight light = new DirectionalLight(
                    worldLight,
                    worldLight.getNumberOfRays(),
                    colorFactory.createColor(prototype.getColorPrototype()),
                    prototype.getDirectionDegree()
            );
            light.setXray(prototype.getXRay());
            return light;
        } catch (Exception e) {
            throw new LightCreateException(prototype, e);
        }
    }

    @Override
    public DirectionalLight createLight(DirectionalLightPrototype prototype, WorldLight worldLight, Body body, Scale scale) {
        throw new UnsupportedOperationException("Directional light cannot be attached to body.");
    }

    @Override
    public Class<DirectionalLightPrototype> getFactoryType() {
        return DirectionalLightPrototype.class;
    }
}
