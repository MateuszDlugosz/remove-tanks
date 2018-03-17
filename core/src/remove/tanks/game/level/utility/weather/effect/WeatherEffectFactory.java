package remove.tanks.game.level.utility.weather.effect;

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
    private final Map<Class<? extends WeatherEffectPrefab>, SubWeatherEffectFactory> factories
            = new HashMap<>();

    public WeatherEffectFactory(SubWeatherEffectFactory[] factories) {
        Arrays.stream(factories).forEach(f -> this.factories.put(f.getFactoryType(), f));
    }

    public List<WeatherEffect> createWeatherEffects(List<WeatherEffectPrefab> prefabs, ResourceRegistry resourceRegistry) {
        return prefabs.stream()
                .map(p -> createWeatherEffect(p, resourceRegistry))
                .collect(Collectors.toList());
    }

    public WeatherEffect createWeatherEffect(WeatherEffectPrefab prefab, ResourceRegistry resourceRegistry) {
        try {
            if (!factories.containsKey(prefab.getClass())) {
                throw new WeatherEffectFactoryNotFoundException(prefab.getClass());
            }
            return factories.get(prefab.getClass()).createWeatherEffect(prefab, resourceRegistry);
        } catch (Exception e) {
            throw new WeatherEffectCreateException(prefab, e);
        }
    }
}
