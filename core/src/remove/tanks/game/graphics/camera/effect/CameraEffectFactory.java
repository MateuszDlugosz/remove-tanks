package remove.tanks.game.graphics.camera.effect;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
@SuppressWarnings("unchecked")
public final class CameraEffectFactory {
    private final Map<Class<? extends CameraEffectPrefab>, SubCameraEffectFactory> factories
            = new HashMap<>();

    public CameraEffectFactory(SubCameraEffectFactory[] factories) {
        Arrays.stream(factories).forEach(f -> this.factories.put(f.getFactoryType(), f));
    }

    public List<CameraEffect> createCameraEffects(List<CameraEffectPrefab> prefabs) {
        return prefabs.stream()
                .map(this::createCameraEffect)
                .collect(Collectors.toList());
    }

    public CameraEffect createCameraEffect(CameraEffectPrefab prefab) {
        try {
            if (!factories.containsKey(prefab.getClass())) {
                throw new CameraEffectFactoryNotFoundException(prefab.getClass());
            }
            return factories.get(prefab.getClass()).createCameraEffect(prefab);
        } catch (Exception e) {
            throw new CameraEffectCreateException(prefab, e);
        }
    }
}
