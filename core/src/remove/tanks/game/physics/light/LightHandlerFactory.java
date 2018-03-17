package remove.tanks.game.physics.light;

import com.badlogic.gdx.physics.box2d.Body;
import remove.tanks.game.physics.light.world.WorldLight;
import remove.tanks.game.utility.scale.Scale;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class LightHandlerFactory {
    private final LightFactory lightFactory;

    public LightHandlerFactory(LightFactory lightFactory) {
        this.lightFactory = lightFactory;
    }

    public List<LightHandler> createLightHandlers(List<LightHandlerPrefab> prefabs, WorldLight worldLight, Scale scale) {
        return prefabs.stream()
                .map(p -> createLightHandler(p, worldLight, scale))
                .collect(Collectors.toList());
    }

    public LightHandler createLightHandler(LightHandlerPrefab prefab, WorldLight worldLight, Scale scale) {
        try {
            return new LightHandler(
                    prefab.getId(),
                    lightFactory.createLight(
                            prefab.getLightPrefab(),
                            worldLight,
                            scale
                    )
            );
        } catch (Exception e) {
            throw new LightHandlerCreateException(prefab, e);
        }
    }

    public List<LightHandler> createLightHandlers(List<LightHandlerPrefab> prefabs, Body body, WorldLight worldLight, Scale scale) {
        return prefabs.stream()
                .map(p -> createLightHandler(p, body, worldLight, scale))
                .collect(Collectors.toList());
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
