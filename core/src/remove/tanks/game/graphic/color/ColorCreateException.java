package remove.tanks.game.graphic.color;

/**
 * @author Mateusz Długosz
 */
public final class ColorCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create color from prototype %s.";

    public ColorCreateException(ColorPrototype prototype, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prototype), cause);
    }
}
