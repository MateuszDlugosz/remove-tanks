package remove.tanks.game.physics.light;

/**
 * @author Mateusz Długosz
 */
public final class LightPrefabReaderNotFoundException extends RuntimeException {
    private final static String MESSAGE_TEMPLATE = "Light prefab reader of %s not found.";

    public LightPrefabReaderNotFoundException(LightType lightType) {
        super(String.format(MESSAGE_TEMPLATE, lightType));
    }
}
