package remove.tanks.game.level.engine.system.environment.weather.effect;

import remove.tanks.game.level.resource.ResourceRegistry;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
@SuppressWarnings("unchecked")
public final class WeatherEffectFactory {
    private final Map<Class<? extends WeatherEffectPrototype>, RegistrableWeatherEffectFactory> factories
            = new HashMap<>();

    public WeatherEffectFactory(RegistrableWeatherEffectFactory[] factories) {
        Arrays.stream(factories).forEach(f -> this.factories.put(f.getFactoryType(), f));
    }

    public List<WeatherEffect> createWeatherEffects(List<WeatherEffectPrototype> prototypes, ResourceRegistry resourceRegistry) {
        return prototypes.stream()
                .map(p -> createWeatherEffect(p, resourceRegistry))
                .collect(Collectors.toList());
    }

    public WeatherEffect createWeatherEffect(WeatherEffectPrototype prototype, ResourceRegistry resourceRegistry) {
        try {
            if (!factories.containsKey(prototype.getClass())) {
                throw new WeatherEffectFactoryNotFoundException(prototype.getClass());
            }
            return factories.get(prototype.getClass()).createWeatherEffect(prototype, resourceRegistry);
        } catch (Exception e) {
            throw new WeatherEffectCreateException(prototype, e);
        }
    }
}
