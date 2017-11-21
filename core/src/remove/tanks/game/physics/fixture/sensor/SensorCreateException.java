package remove.tanks.game.physics.fixture.sensor;

/**
 * @author Mateusz Długosz
 */
public final class SensorCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create sensor from prototype %s.";

    public SensorCreateException(SensorPrototype prototype, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prototype), cause);
    }
}
