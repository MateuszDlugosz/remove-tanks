package remove.tanks.game.level;

/**
 * @author Mateusz Długosz
 */
public final class LevelInitializeException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot initialize level.";

    public LevelInitializeException(Throwable cause) {
        super(MESSAGE_TEMPLATE, cause);
    }
}
