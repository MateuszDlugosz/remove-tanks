package remove.tanks.game.physics.body;

/**
 * @author Mateusz Długosz
 */
public final class BodyCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create body from prototype %s.";

    public BodyCreateException(BodyPrototype prototype, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prototype), cause);
    }
}
