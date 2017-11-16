package remove.tanks.game.graphic.view.renderer;

/**
 * @author Mateusz Długosz
 */
public final class ViewRendererNotFoundException extends RuntimeException {
    public static final String MESSAGE_TEMPLATE = "ViewRenderer of view class %s not found.";

    public ViewRendererNotFoundException(String viewClassName) {
        super(String.format(MESSAGE_TEMPLATE, viewClassName));
    }
}
