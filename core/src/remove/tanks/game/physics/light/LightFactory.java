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
    private final Map<Class<? extends LightPrototype>, RegistrableLightFactory> factories
            = new HashMap<>();

    public LightFactory(RegistrableLightFactory[] factories) {
        Arrays.stream(factories).forEach(s -> this.factories.put(s.getFactoryType(), s));
    }

    public List<Light> createLights(List<LightPrototype> prototypes, WorldLight worldLight, Scale scale) {
        return prototypes.stream()
                .map(p -> createLight(p, worldLight, scale))
                .collect(Collectors.toList());
    }

    public Light createLight(LightPrototype prototype, WorldLight worldLight, Scale scale) {
        Class<? extends LightPrototype> prototypeClass = prototype.getClass();
        if (!factories.containsKey(prototypeClass)) {
            throw new LightFactoryNotFoundException(prototypeClass.toString());
        }
        return factories.get(prototypeClass).createLight(prototype, worldLight, scale);
    }

    public List<Light> createLights(List<LightPrototype> prototypes, WorldLight worldLight, Body body, Scale scale) {
        return prototypes.stream()
                .map(p -> createLight(p, worldLight, body, scale))
                .collect(Collectors.toList());
    }

    public Light createLight(LightPrototype prototype, WorldLight worldLight, Body body, Scale scale) {
        try {
            Class<? extends LightPrototype> prototypeClass = prototype.getClass();
            if (!factories.containsKey(prototypeClass)) {
                throw new LightFactoryNotFoundException(prototypeClass.toString());
            }
            return factories.get(prototypeClass).createLight(prototype, worldLight, body, scale);
        } catch (Exception e) {
            throw new LightCreateException(prototype, e);
        }
    }
}
