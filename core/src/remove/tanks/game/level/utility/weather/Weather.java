package remove.tanks.game.level.utility.weather;

import remove.tanks.game.level.utility.weather.effect.WeatherEffect;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class Weather {
    private final List<WeatherEffect> effects;

    public Weather(List<WeatherEffect> effects) {
        this.effects = effects;
    }

    public void addWeatherEffect(WeatherEffect effect) {
        effects.add(effect);
    }

    public void clearWeatherEffects() {
        effects.clear();
    }

    public void update(float delta) {
        effects.forEach(e -> e.update(delta));
    }
}
