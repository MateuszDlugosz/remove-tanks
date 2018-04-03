package remove.tanks.game.level.event.weather;

import remove.tanks.game.level.event.Event;
import remove.tanks.game.level.utility.weather.effect.WeatherEffect;

/**
 * @author Mateusz Długosz
 */
public final class AddWeatherEffectEvent implements Event {
    private final WeatherEffect weatherEffect;

    public AddWeatherEffectEvent(WeatherEffect weatherEffect) {
        this.weatherEffect = weatherEffect;
    }

    public WeatherEffect getWeatherEffect() {
        return weatherEffect;
    }
}
