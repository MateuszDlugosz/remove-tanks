package remove.tanks.game.graphics.color;

/**
 * @author Mateusz Długosz
 */
public final class ColorCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create color from prefab %s.";

    public ColorCreateException(ColorPrefab prefab, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prefab), cause);
    }
}