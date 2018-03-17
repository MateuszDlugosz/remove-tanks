package remove.tanks.game.graphics.color;

/**
 * @author Mateusz Długosz
 */
public final class ColorPrefabReaderNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Color prefab reader of %s not found.";

    public ColorPrefabReaderNotFoundException(ColorType colorType) {
        super(String.format(MESSAGE_TEMPLATE, colorType));
    }
}
