package remove.tanks.game.physics.shape;

/**
 * @author Mateusz Długosz
 */
public final class ShapePrototypeLoaderNotFoundException extends RuntimeException {
    private final static String MESSAGE_TEMPLATE = "Shape prototype loader of %s not found.";

    public ShapePrototypeLoaderNotFoundException(ShapeType type) {
        super(String.format(MESSAGE_TEMPLATE, type));
    }
}
