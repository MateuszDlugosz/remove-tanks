package remove.tanks.game.level.mode.arena;

/**
 * @author Mateusz Długosz
 */
public final class ArenaStorageCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create arena storage.";

    public ArenaStorageCreateException(Throwable cause) {
        super(MESSAGE_TEMPLATE, cause);
    }
}
