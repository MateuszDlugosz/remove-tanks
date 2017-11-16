package remove.tanks.game.asset;

/**
 * @author Mateusz Długosz
 */
public final class AssetStorageCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create asset storage.";

    public AssetStorageCreateException(Throwable cause) {
        super(cause);
    }
}
