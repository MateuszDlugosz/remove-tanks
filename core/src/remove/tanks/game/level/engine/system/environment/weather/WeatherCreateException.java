package remove.tanks.game.level.engine.system.environment.weather;

/**
 * @author Mateusz Długosz
 */
public final class WeatherCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create weather from prototype %s.";

    public WeatherCreateException(WeatherPrototype prototype, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prototype), cause);
    }
}
