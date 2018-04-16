package remove.tanks.game.desktop.display;

import com.badlogic.gdx.Graphics;

/**
 * @author Mateusz Długosz
 */
public final class DisplayDimensionResolveException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot resolve dimension from display mode %s.";

    public DisplayDimensionResolveException(Graphics.DisplayMode displayMode, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE,
                String.format("%s x %s", displayMode.width, displayMode.height)), cause);
    }
}
