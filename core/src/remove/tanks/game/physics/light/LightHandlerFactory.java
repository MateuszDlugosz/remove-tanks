package remove.tanks.game.physics.light;

import com.badlogic.gdx.physics.box2d.Body;
import remove.tanks.game.physics.light.world.WorldLight;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class LightHandlerFactory {
    private final LightFactory lightFactory;

    public LightHandlerFactory(LightFactory lightFactory) {
        this.lightFactory = lightFactory;
    }

    public LightHandler createLightHandler(LightHandlerPrefab prefab, Body body, WorldLight worldLight, Scale scale) {
        try {
            return new LightHandler(
                    prefab.getId(),
                    lightFactory.createLight(
                            prefab.getLightPrefab(),
                            worldLight,
                            body,
                            scale
                    )
            );
        } catch (Exception e) {
            throw new LightHandlerCreateException(prefab, e);
        }
    }
}
