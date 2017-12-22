package remove.tanks.game.level.engine.system.hud.stages.widget;

/**
 * @author Mateusz Długosz
 */
public final class WidgetCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create widget from prototype %s.";

    public WidgetCreateException(WidgetPrototype prototype, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prototype), cause);
    }
}
