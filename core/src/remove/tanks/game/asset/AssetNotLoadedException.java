package remove.tanks.game.asset;

/**
 * @author Mateusz Długosz
 */
public final class AssetNotLoadedException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Asset id %s of %s from file %s is not loaded.";

    public AssetNotLoadedException(String id, String filename, Class<?> className) {
        super(String.format(MESSAGE_TEMPLATE, id, className.toString(), filename));
    }
}
