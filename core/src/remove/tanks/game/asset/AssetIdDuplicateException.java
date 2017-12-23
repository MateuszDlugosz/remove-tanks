package remove.tanks.game.asset;

/**
 * @author Mateusz Długosz
 */
public final class AssetIdDuplicateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Asset id %s duplication.";

    public AssetIdDuplicateException(String id) {
        super(String.format(MESSAGE_TEMPLATE, id));
    }
}
