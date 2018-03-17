package remove.tanks.game.level.utility.stage.widget;

/**
 * @author Mateusz Długosz
 */
public final class WidgetPrefabReaderNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Widget prefab reader of %s not found.";

    public WidgetPrefabReaderNotFoundException(WidgetType type) {
        super(String.format(MESSAGE_TEMPLATE, type));
    }
}
