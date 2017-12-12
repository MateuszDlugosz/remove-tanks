package remove.tanks.game.level.engine.system.environment.weather;

import remove.tanks.game.level.engine.system.environment.weather.effect.WeatherEffect;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class Weather {
    private final List<WeatherEffect> effects;

    public Weather(List<WeatherEffect> effects) {
        this.effects = effects;
    }

    public void update(float delta) {
        effects.forEach(e -> e.update(delta));
    }
}
