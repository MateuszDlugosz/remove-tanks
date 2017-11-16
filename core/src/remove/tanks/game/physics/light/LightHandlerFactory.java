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

    public List<LightHandler> createLightHandlers(List<LightHandlerPrototype> prototypes, WorldLight worldLight, Scale scale) {
        return prototypes.stream()
                .map(p -> createLightHandler(p, worldLight, scale))
                .collect(Collectors.toList());
    }

    public LightHandler createLightHandler(LightHandlerPrototype prototype, WorldLight worldLight, Scale scale) {
        try {
            return new LightHandler(
                    prototype.getId(),
                    lightFactory.createLight(
                            prototype.getLightPrototype(),
                            worldLight,
                            scale
                    )
            );
        } catch (Exception e) {
            throw new LightHandlerCreateException(prototype, e);
        }
    }

    public List<LightHandler> createLightHandlers(List<LightHandlerPrototype> prototypes, Body body, WorldLight worldLight, Scale scale) {
        return prototypes.stream()
                .map(p -> createLightHandler(p, body, worldLight, scale))
                .collect(Collectors.toList());
    }

    public LightHandler createLightHandler(LightHandlerPrototype prototype, Body body, WorldLight worldLight, Scale scale) {
        try {
            return new LightHandler(
                    prototype.getId(),
                    lightFactory.createLight(
                            prototype.getLightPrototype(),
                            worldLight,
                            body,
                            scale
                    )
            );
        } catch (Exception e) {
            throw new LightHandlerCreateException(prototype, e);
        }
    }
}
