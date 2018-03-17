package remove.tanks.game.level.utility.weather.effect;

/**
 * @author Mateusz Długosz
 */
public final class WeatherEffectPrefabReaderNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Weather effect reader of type %s not found.";

    public WeatherEffectPrefabReaderNotFoundException(WeatherEffectType type) {
        super(String.format(MESSAGE_TEMPLATE, type));
    }
}
