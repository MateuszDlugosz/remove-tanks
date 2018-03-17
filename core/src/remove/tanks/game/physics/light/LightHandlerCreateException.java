package remove.tanks.game.physics.light;

/**
 * @author Mateusz Długosz
 */
public final class LightHandlerCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create light handler from prefab %s.";

    public LightHandlerCreateException(LightHandlerPrefab prefab, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prefab), cause);
    }
}