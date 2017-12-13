package remove.tanks.game.graphic.view.renderer;

import remove.tanks.game.graphic.view.View;

/**
 * @author Mateusz Długosz
 */
public final class ViewRendererNotFoundException extends RuntimeException {
    public static final String MESSAGE_TEMPLATE = "ViewRenderer of view class %s not found.";

    public ViewRendererNotFoundException(Class<? extends View> viewClass) {
        super(String.format(MESSAGE_TEMPLATE, viewClass));
    }
}
