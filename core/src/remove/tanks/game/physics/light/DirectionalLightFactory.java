package remove.tanks.game.physics.light;

import box2dLight.DirectionalLight;
import com.badlogic.gdx.physics.box2d.Body;
import remove.tanks.game.graphics.color.ColorFactory;
import remove.tanks.game.physics.light.world.WorldLight;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class DirectionalLightFactory implements SubLightFactory<DirectionalLight, DirectionalLightPrefab> {
    private final ColorFactory colorFactory;

    public DirectionalLightFactory(ColorFactory colorFactory) {
        this.colorFactory = colorFactory;
    }

    @Override
    public DirectionalLight createLight(DirectionalLightPrefab prefab, WorldLight worldLight, Scale scale) {
        try {
            DirectionalLight light = new DirectionalLight(
                    worldLight,
                    worldLight.getNumberOfRays(),
                    colorFactory.createColor(prefab.getColorPrefab()),
                    prefab.getDirectionDegree()
            );
            light.setXray(prefab.getXRay());
            return light;
        } catch (Exception e) {
            throw new LightCreateException(prefab, e);
        }
    }

    @Override
    public DirectionalLight createLight(DirectionalLightPrefab prefab, WorldLight worldLight, Body body, Scale scale) {
        throw new UnsupportedOperationException("Directional light cannot be attached to body.");
    }

    @Override
    public Class<DirectionalLightPrefab> getFactoryType() {
        return DirectionalLightPrefab.class;
    }
}
