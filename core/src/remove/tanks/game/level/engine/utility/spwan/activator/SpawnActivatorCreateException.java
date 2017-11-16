package remove.tanks.game.level.engine.utility.spwan.activator;

/**
 * @author Mateusz Długosz
 */
public final class SpawnActivatorCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create spawn activator from prototype %s.";

    public SpawnActivatorCreateException(SpawnerActivatorPrototype prototype, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prototype), cause);
    }
}
