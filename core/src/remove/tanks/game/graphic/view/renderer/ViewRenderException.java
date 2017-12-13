package remove.tanks.game.graphic.view.renderer;

import remove.tanks.game.graphic.view.View;

/**
 * @author Mateusz Długosz
 */
public final class ViewRenderException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot render view %s.";

    public ViewRenderException(View view, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, view), cause);
    }
}
