package remove.tanks.game.level.engine.utility.spwan.spawner;

/**
 * @author Mateusz Długosz
 */
public final class SpawnerCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create spawner from prototype %s.";

    public SpawnerCreateException(SpawnerPrototype prototype, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prototype), cause);
    }
}
