package remove.tanks.game.level.engine.system.environment.weather.effect;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class WeatherEffectPrototypeXmlLoader {
    public static final String WEATHER_EFFECT_ELEMENT = "weatherEffect";
    public static final String WEATHER_EFFECTS_ELEMENT = "weatherEffects";

    private static final String TYPE_ATTRIBUTE = "type";

    private final Map<WeatherEffectType, RegistrableWeatherEffectPrototypeXmlLoader> loaders
            = new HashMap<>();

    public WeatherEffectPrototypeXmlLoader(RegistrableWeatherEffectPrototypeXmlLoader[] loaders) {
        Arrays.stream(loaders).forEach(l -> this.loaders.put(l.getLoaderType(), l));
    }

    public List<WeatherEffectPrototype> loadWeatherEffectPrototypes(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(WEATHER_EFFECT_ELEMENT).toArray())
                .map(this::loadWeatherEffectPrototype)
                .collect(Collectors.toList());
    }

    public WeatherEffectPrototype loadWeatherEffectPrototype(XmlReader.Element element) {
        try {
            WeatherEffectType type = WeatherEffectType.valueOf(element.getAttribute(TYPE_ATTRIBUTE).trim());
            if (!loaders.containsKey(type)) {
                throw new WeatherEffectPrototypeLoaderNotFoundException(type);
            }
            return loaders.get(type).loadWeatherEffect(element);
        } catch (Exception e) {
            throw new WeatherEffectPrototypeXmlLoadException(element, e);
        }
    }
}
