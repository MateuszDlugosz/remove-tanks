package remove.tanks.game.level.utility.weather.effect;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class WeatherEffectPrefabXmlReader {
    public static final String WEATHER_EFFECT_ELEMENT = "weatherEffect";
    public static final String WEATHER_EFFECTS_ELEMENT = "weatherEffects";

    private static final String TYPE_ATTRIBUTE = "type";

    private final Map<WeatherEffectType, SubWeatherEffectPrefabXmlReader> readers
            = new HashMap<>();

    public WeatherEffectPrefabXmlReader(SubWeatherEffectPrefabXmlReader[] readers) {
        Arrays.stream(readers).forEach(l -> this.readers.put(l.getReaderType(), l));
    }

    public List<WeatherEffectPrefab> readWeatherEffectPrefabs(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(WEATHER_EFFECT_ELEMENT).toArray())
                .map(this::readWeatherEffectPrefab)
                .collect(Collectors.toList());
    }

    public WeatherEffectPrefab readWeatherEffectPrefab(XmlReader.Element element) {
        try {
            WeatherEffectType type = WeatherEffectType.valueOf(element.getAttribute(TYPE_ATTRIBUTE).trim());
            if (!readers.containsKey(type)) {
                throw new WeatherEffectPrefabReaderNotFoundException(type);
            }
            return readers.get(type).readWeatherEffect(element);
        } catch (Exception e) {
            throw new WeatherEffectPrefabXmlReadException(element, e);
        }
    }
}
