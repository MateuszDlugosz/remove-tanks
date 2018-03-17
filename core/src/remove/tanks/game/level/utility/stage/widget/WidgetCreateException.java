package remove.tanks.game.level.utility.stage.widget;

/**
 * @author Mateusz Długosz
 */
public final class WidgetCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create widget from prefab %s.";

    public WidgetCreateException(WidgetPrefab prefab, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prefab), cause);
    }
}
