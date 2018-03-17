package remove.tanks.game.physics.shape;

/**
 * @author Mateusz Długosz
 */
public final class ShapeCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create shape from prefab %s.";

    public ShapeCreateException(ShapePrefab prefab, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prefab), cause);
    }
}
