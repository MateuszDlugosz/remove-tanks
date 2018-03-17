package remove.tanks.game.asset;

/**
 * @author Mateusz Długosz
 */
public final class AssetPrefabRepositoryXmlReadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot read asset prefab repository from file %s.";

    public AssetPrefabRepositoryXmlReadException(String filename, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, filename), cause);
    }
}
