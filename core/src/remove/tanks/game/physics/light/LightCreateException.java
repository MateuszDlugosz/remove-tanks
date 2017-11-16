package remove.tanks.game.physics.light;

/**
 * @author Mateusz Długosz
 */
public final class LightCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create light from prototype %s.";

    public LightCreateException(LightPrototype prototype, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prototype), cause);
    }
}
