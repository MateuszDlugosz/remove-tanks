package remove.tanks.game.level.utility.weather.effect;

/**
 * @author Mateusz Długosz
 */
public final class WeatherEffectFactoryNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Weather effect factory of %s type not found.";

    public WeatherEffectFactoryNotFoundException(Class<? extends WeatherEffectPrefab> type) {
        super(String.format(MESSAGE_TEMPLATE, type));
    }
}
