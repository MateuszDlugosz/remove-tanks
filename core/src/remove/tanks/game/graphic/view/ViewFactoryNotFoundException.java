package remove.tanks.game.graphic.view;

/**
 * @author Mateusz Długosz
 */
public final class ViewFactoryNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "View factory of prototype %s not found.";

    public ViewFactoryNotFoundException(Class<? extends ViewPrototype> prototypeClass) {
        super(String.format(MESSAGE_TEMPLATE, prototypeClass));
    }
}
