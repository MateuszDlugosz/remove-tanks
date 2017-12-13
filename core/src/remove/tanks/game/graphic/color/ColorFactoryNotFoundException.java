package remove.tanks.game.graphic.color;

/**
 * @author Mateusz Długosz
 */
public final class ColorFactoryNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Color factory of %s not found.";

    public ColorFactoryNotFoundException(Class<? extends ColorPrototype> prototypeClass) {
        super(String.format(MESSAGE_TEMPLATE, prototypeClass));
    }
}
