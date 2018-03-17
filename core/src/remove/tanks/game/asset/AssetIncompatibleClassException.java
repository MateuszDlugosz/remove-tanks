package remove.tanks.game.asset;

/**
 * @author Mateusz Długosz
 */
public final class AssetIncompatibleClassException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Asset is loaded as %s class but expected %s.";

    public AssetIncompatibleClassException(Class<?> loadedClass, Class<?> expectedClass) {
        super(String.format(MESSAGE_TEMPLATE, loadedClass, expectedClass));
    }
}
