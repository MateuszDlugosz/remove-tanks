package remove.tanks.game.utility.surface.boundary;

/**
 * @author Mateusz Długosz
 */
public final class InvalidBoundaryValueException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Min %s boundary value cannot be greater than max $s.";

    public enum Axis { X, Y }

    public InvalidBoundaryValueException(Axis axis) {
        super(String.format(MESSAGE_TEMPLATE, axis.toString()));
    }
}
