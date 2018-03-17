package remove.tanks.game.physics.light.world;

/**
 * @author Mateusz Długosz
 */
public final class WorldLightCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create world light.";

    public WorldLightCreateException(Throwable cause) {
        super(MESSAGE_TEMPLATE, cause);
    }
}
