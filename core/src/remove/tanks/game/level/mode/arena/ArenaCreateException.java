package remove.tanks.game.level.mode.arena;

/**
 * @author Mateusz Długosz
 */
public final class ArenaCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create arena from prefab %s.";

    public ArenaCreateException(ArenaPrefab prefab, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prefab), cause);
    }
}
