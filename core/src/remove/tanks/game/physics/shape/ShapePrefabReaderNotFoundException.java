package remove.tanks.game.physics.shape;

/**
 * @author Mateusz Długosz
 */
public final class ShapePrefabReaderNotFoundException extends RuntimeException {
    private final static String MESSAGE_TEMPLATE = "Shape prefab reader of %s not found.";

    public ShapePrefabReaderNotFoundException(ShapeType shapeType) {
        super(String.format(MESSAGE_TEMPLATE, shapeType));
    }
}
