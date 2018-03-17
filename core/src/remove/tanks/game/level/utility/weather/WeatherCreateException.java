package remove.tanks.game.level.utility.weather;

/**
 * @author Mateusz Długosz
 */
public final class WeatherCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create weather from prefab %s.";

    public WeatherCreateException(WeatherPrefab prefab, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prefab), cause);
    }
}
