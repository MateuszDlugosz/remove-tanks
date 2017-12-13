package remove.tanks.game.level.engine.system.environment.weather.effect;

/**
 * @author Mateusz Długosz
 */
public final class WeatherEffectPrototypeLoaderNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Weather effect loader of type %s not found.";

    public WeatherEffectPrototypeLoaderNotFoundException(WeatherEffectType type) {
        super(String.format(MESSAGE_TEMPLATE, type));
    }
}
