package remove.tanks.game.level.engine;

/**
 * @author Mateusz Długosz
 */
public final class EngineCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create engine from prefab %s.";

    public EngineCreateException(EnginePrefab prefab, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prefab), cause);
    }
}
