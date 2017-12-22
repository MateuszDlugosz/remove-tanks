package remove.tanks.game.level.engine.system.hud.stages.widget;

/**
 * @author Mateusz Długosz
 */
public final class WidgetFactoryNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Widget factory of %s prototype not found.";

    public WidgetFactoryNotFoundException(Class<? extends WidgetPrototype> prototypeClass) {
        super(String.format(MESSAGE_TEMPLATE, prototypeClass));
    }
}
