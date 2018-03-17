package remove.tanks.game.level.utility.stage.widget;

/**
 * @author Mateusz Długosz
 */
public final class WidgetFactoryNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Widget factory of %s prefab not found.";

    public WidgetFactoryNotFoundException(Class<? extends WidgetPrefab> prefabClass) {
        super(String.format(MESSAGE_TEMPLATE, prefabClass));
    }
}
