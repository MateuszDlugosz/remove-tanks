package remove.tanks.game.graphic.color;

/**
 * @author Mateusz Długosz
 */
public final class ColorFactoryNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Sub color factory of %s not found.";

    public ColorFactoryNotFoundException(String colorPrototypeClass) {
        super(String.format(MESSAGE_TEMPLATE, colorPrototypeClass));
    }
}
