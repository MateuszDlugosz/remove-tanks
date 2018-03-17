package remove.tanks.game.graphics.view;

/**
 * @author Mateusz Długosz
 */
public final class ViewFactoryNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "View factory of prefab %s not found.";

    public ViewFactoryNotFoundException(Class<? extends ViewPrefab> prefabClass) {
        super(String.format(MESSAGE_TEMPLATE, prefabClass));
    }
}
