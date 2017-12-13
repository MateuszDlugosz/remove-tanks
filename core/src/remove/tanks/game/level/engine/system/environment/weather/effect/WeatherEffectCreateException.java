package remove.tanks.game.level.engine.system.environment.weather.effect;

/**
 * @author Mateusz Długosz
 */
public final class WeatherEffectCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Can not create weather effect from prototype %s.";

    public WeatherEffectCreateException(WeatherEffectPrototype prototype, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prototype), cause);
    }
}
