package remove.tanks.game.level.utility.weather.effect;

/**
 * @author Mateusz Długosz
 */
public interface WeatherEffect {
    String getId();
    void update(float delta);
}
