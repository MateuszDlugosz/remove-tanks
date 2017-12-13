package remove.tanks.game.level.engine.system.environment.weather.effect;

/**
 * @author Mateusz Długosz
 */
public final class WeatherEffectFactoryNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Weather effect factory of %s type not found.";

    public WeatherEffectFactoryNotFoundException(Class<? extends WeatherEffectPrototype> type) {
        super(String.format(MESSAGE_TEMPLATE, type));
    }
}
