package remove.tanks.game.utility.boundary;

/**
 * @author Mateusz Długosz
 */
public final class BoundariesCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create boundaries from prototype %s.";

    public BoundariesCreateException(BoundariesPrototype prototype, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prototype), cause);
    }
}
