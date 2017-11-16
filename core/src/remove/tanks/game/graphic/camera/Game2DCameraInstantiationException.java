package remove.tanks.game.graphic.camera;

/**
 * @author Mateusz Długosz
 */
public final class Game2DCameraInstantiationException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE
            = "Game2DCamera and viewport parameter should use the same OrthographicCamera.";

    public Game2DCameraInstantiationException() {
        super(MESSAGE_TEMPLATE);
    }
}
