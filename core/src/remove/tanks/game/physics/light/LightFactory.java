package remove.tanks.game.physics.light;

import box2dLight.Light;
import com.badlogic.gdx.physics.box2d.Body;
import remove.tanks.game.physics.light.world.WorldLight;
import remove.tanks.game.utility.scale.Scale;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
@SuppressWarnings("unchecked")
public final class LightFactory {
    private final Map<Class<? extends LightPrefab>, SubLightFactory> factories
            = new HashMap<>();

    public LightFactory(SubLightFactory[] factories) {
        Arrays.stream(factories).forEach(s -> this.factories.put(s.getFactoryType(), s));
    }

    public Light createLight(LightPrefab prefab, WorldLight worldLight, Scale scale) {
        try {
            if (!factories.containsKey(prefab.getClass())) {
                throw new LightFactoryNotFoundException(prefab.getClass());
            }
            return factories.get(prefab.getClass()).createLight(prefab, worldLight, scale);
        } catch (Exception e) {
            throw new LightCreateException(prefab, e);
        }
    }

    public List<Light> createLights(List<LightPrefab> prefabs, WorldLight worldLight, Body body, Scale scale) {
        return prefabs.stream()
                .map(p -> createLight(p, worldLight, body, scale))
                .collect(Collectors.toList());
    }

    public Light createLight(LightPrefab prefab, WorldLight worldLight, Body body, Scale scale) {
        try {
            if (!factories.containsKey(prefab.getClass())) {
                throw new LightFactoryNotFoundException(prefab.getClass());
            }
            return factories.get(prefab.getClass()).createLight(prefab, worldLight, body, scale);
        } catch (Exception e) {
            throw new LightCreateException(prefab, e);
        }
    }
}
