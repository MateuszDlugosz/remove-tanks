package remove.tanks.game.level;

/**
 * @author Mateusz Długosz
 */
public final class LevelPresenterCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create level presenter from prefab %s.";

    public LevelPresenterCreateException(LevelPresenterPrefab prefab, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prefab), cause);
    }
}
