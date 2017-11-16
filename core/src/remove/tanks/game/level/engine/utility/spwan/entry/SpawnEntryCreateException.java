package remove.tanks.game.level.engine.utility.spwan.entry;

/**
 * @author Mateusz Długosz
 */
public final class SpawnEntryCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create spawn entry from prototype %s.";

    public SpawnEntryCreateException(SpawnEntryPrototype prototype, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prototype), cause);
    }
}
