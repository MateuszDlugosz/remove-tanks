package remove.tanks.game.asset;

/**
 * @author Mateusz Długosz
 */
public final class AssetLoadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot load asset with id %s.";

    public AssetLoadException(String id, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, id), cause);
    }
}
