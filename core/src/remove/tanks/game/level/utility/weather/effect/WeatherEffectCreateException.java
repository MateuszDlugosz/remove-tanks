package remove.tanks.game.level.utility.weather.effect;

/**
 * @author Mateusz Długosz
 */
public final class WeatherEffectCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create weather effect form prefab %s.";

    public WeatherEffectCreateException(WeatherEffectPrefab prefab, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prefab), cause);
    }
}
