package remove.tanks.game.physics.shape;

/**
 * @author Mateusz Długosz
 */
public final class ShapeCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create shape from prototype %s.";

    public ShapeCreateException(ShapePrototype prototype, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prototype), cause);
    }
}
