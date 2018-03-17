package remove.tanks.game.level;

/**
 * @author Mateusz Długosz
 */
public final class LevelCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create level from prefab %s.";

    public LevelCreateException(LevelPrefab prefab, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prefab), cause);
    }
}
