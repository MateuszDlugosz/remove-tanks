package remove.tanks.game.utility.position;

/**
 * @author Mateusz Długosz
 */
public final class PositionCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create position from prototype %s.";

    public PositionCreateException(PositionPrototype prototype, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prototype), cause);
    }
}
