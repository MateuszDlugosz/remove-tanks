package remove.tanks.game.asset;

/**
 * @author Mateusz Długosz
 */
public final class AssetIdNotExistsException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Asset id %s not exists.";

    public AssetIdNotExistsException(String id) {
        super(String.format(MESSAGE_TEMPLATE, id));
    }
}
