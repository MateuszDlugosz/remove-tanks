package remove.tanks.game.physics.light;

/**
 * @author Mateusz Długosz
 */
public final class LightFactoryNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Light factory of prefab %s not found.";

    public LightFactoryNotFoundException(Class<? extends LightPrefab> prefabClass) {
        super(String.format(MESSAGE_TEMPLATE, prefabClass));
    }
}
