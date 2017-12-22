package remove.tanks.game.level.engine.system.hud.stages.widget;

/**
 * @author Mateusz Długosz
 */
public final class WidgetPrototypeLoaderNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Widget prototype loader of %s not found.";

    public WidgetPrototypeLoaderNotFoundException(WidgetType type) {
        super(String.format(MESSAGE_TEMPLATE, type));
    }
}
