package remove.tanks.game.graphic.view;

/**
 * @author Mateusz Długosz
 */
public final class ViewPrototypeLoaderNotFoundException extends RuntimeException {
    private final static String MESSAGE_TEMPLATE = "View prototype loader of %s not found.";

    public ViewPrototypeLoaderNotFoundException(ViewType type) {
        super(String.format(MESSAGE_TEMPLATE, type));
    }
}
