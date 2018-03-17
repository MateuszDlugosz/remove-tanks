package remove.tanks.game.utility.surface.boundary;

/**
 * @author Mateusz Długosz
 */
public final class BoundaryCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create boundaries from prefab %s.";

    public BoundaryCreateException(BoundaryPrefab prefab, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prefab), cause);
    }
}
