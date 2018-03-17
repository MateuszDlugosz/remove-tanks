package remove.tanks.game.level.utility.stage.state;

/**
 * @author Mateusz Długosz
 */
public final class StateBarCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create state bar from prefab %s.";

    public StateBarCreateException(StateBarPrefab prefab, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prefab), cause);
    }
}
