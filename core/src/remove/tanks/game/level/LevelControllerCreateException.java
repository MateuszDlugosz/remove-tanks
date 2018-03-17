package remove.tanks.game.level;

/**
 * @author Mateusz Długosz
 */
public final class LevelControllerCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create level controller.";

    public LevelControllerCreateException(Throwable cause) {
        super(MESSAGE_TEMPLATE, cause);
    }
}
