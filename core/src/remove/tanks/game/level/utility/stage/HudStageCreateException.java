package remove.tanks.game.level.utility.stage;

/**
 * @author Mateusz Długosz
 */
public final class HudStageCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create hud stage from prefab %s.";

    public HudStageCreateException(HudStagePrefab prefab, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prefab), cause);
    }
}
