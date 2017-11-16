package remove.tanks.game.level.engine.system.respawn;

/**
 * @author Mateusz Długosz
 */
public final class PlayerRespawnNotExistsException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Player respawn does not exists.";

    public PlayerRespawnNotExistsException() {
        super(MESSAGE_TEMPLATE);
    }
}
