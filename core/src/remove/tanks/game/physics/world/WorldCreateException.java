package remove.tanks.game.physics.world;

/**
 * @author Mateusz Długosz
 */
public final class WorldCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create world.";

    public WorldCreateException(Throwable cause) {
        super(MESSAGE_TEMPLATE, cause);
    }
}
