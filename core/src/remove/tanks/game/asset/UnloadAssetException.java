package remove.tanks.game.asset;

/**
 * @author Mateusz Długosz
 */
public final class UnloadAssetException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot unload asset with id %s.";

    public UnloadAssetException(String id, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, id), cause);
    }
}
