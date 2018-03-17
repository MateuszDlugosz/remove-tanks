package remove.tanks.game.utility.surface.position;

/**
 * @author Mateusz Długosz
 */
public final class PositionCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create position from prefab %s.";

    public PositionCreateException(PositionPrefab prefab, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prefab), cause);
    }
}
