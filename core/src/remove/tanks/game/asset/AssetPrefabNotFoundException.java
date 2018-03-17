package remove.tanks.game.asset;

/**
 * @author Mateusz Długosz
 */
public final class AssetPrefabNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Asset prefab %s not found.";

    public AssetPrefabNotFoundException(String id) {
        super(String.format(MESSAGE_TEMPLATE, id));
    }
}
