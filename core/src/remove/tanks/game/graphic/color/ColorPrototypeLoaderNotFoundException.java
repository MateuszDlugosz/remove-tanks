package remove.tanks.game.graphic.color;

/**
 * @author Mateusz Długosz
 */
public final class ColorPrototypeLoaderNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Color prototype loader of %s not found.";

    public ColorPrototypeLoaderNotFoundException(ColorType type) {
        super(String.format(MESSAGE_TEMPLATE, type));
    }
}
