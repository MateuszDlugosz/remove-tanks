package remove.tanks.game.asset;

/**
 * @author Mateusz Długosz
 */
public final class AssetManagerCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create asset manager.";

    public AssetManagerCreateException(Throwable cause) {
        super(MESSAGE_TEMPLATE, cause);
    }
}
