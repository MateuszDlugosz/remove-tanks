package remove.tanks.game.level.engine.system.spawn;

/**
 * @author Mateusz Długosz
 */
public final class RespawnNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Respawn not found on map.";

    public RespawnNotFoundException() {
        super(MESSAGE_TEMPLATE);
    }
}
