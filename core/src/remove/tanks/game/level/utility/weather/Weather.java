package remove.tanks.game.level.utility.weather;

import remove.tanks.game.level.utility.weather.effect.WeatherEffect;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class Weather {
    private final Map<String, WeatherEffect> weatherEffects;
    private final List<String> idsToRemove;

    public Weather(Map<String, WeatherEffect> weatherEffects) {
        this.weatherEffects = weatherEffects;
        this.idsToRemove = new ArrayList<>();
    }

    public void removeWeatherEffect(String id) {
        idsToRemove.add(id);
    }

    public void addWeatherEffect(WeatherEffect effect) {
        weatherEffects.put(effect.getId(), effect);
    }

    public void clearWeatherEffects() {
        idsToRemove.addAll(weatherEffects.keySet());
    }

    public void update(float delta) {
        weatherEffects.values().forEach(e -> e.update(delta));
        idsToRemove.forEach(weatherEffects::remove);
        idsToRemove.clear();
    }
}
