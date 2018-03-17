package remove.tanks.game.graphics.color;

/**
 * @author Mateusz Długosz
 */
public final class ColorFactoryNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Color factory of %s prefab not found.";

    public ColorFactoryNotFoundException(Class<? extends ColorPrefab> prefabClass) {
        super(String.format(MESSAGE_TEMPLATE, prefabClass));
    }
}
