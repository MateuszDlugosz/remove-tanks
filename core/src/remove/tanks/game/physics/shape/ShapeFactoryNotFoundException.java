package remove.tanks.game.physics.shape;

/**
 * @author Mateusz Długosz
 */
public final class ShapeFactoryNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Shape factory of prototype %s not found.";

    public ShapeFactoryNotFoundException(Class<? extends ShapePrototype> prototypeClass) {
        super(String.format(MESSAGE_TEMPLATE, prototypeClass));
    }
}
