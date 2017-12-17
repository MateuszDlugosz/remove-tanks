package remove.tanks.game.graphic.camera.effect;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
@SuppressWarnings("unchecked")
public final class CameraEffectFactory {
    private final Map<Class<? extends CameraEffectPrototype>, RegistrableCameraEffectFactory> factories
            = new HashMap<>();

    public CameraEffectFactory(RegistrableCameraEffectFactory[] factories) {
        Arrays.stream(factories).forEach(f -> this.factories.put(f.getFactoryType(), f));
    }

    public CameraEffect createCameraEffect(CameraEffectPrototype prototype) {
        try {
            if (!factories.containsKey(prototype.getClass())) {
                throw new CameraEffectFactoryNotFoundException(prototype.getClass());
            }
            return factories.get(prototype.getClass()).createCameraEffect(prototype);
        } catch (Exception e) {
            throw new CameraEffectCreateException(prototype, e);
        }
    }
}
