package remove.tanks.game.level.utility.timeline;

/**
 * @author Mateusz Długosz
 */
public final class TimelineEntryCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create timeline entry from prefab %s.";

    public TimelineEntryCreateException(TimelineEntryPrefab prefab, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prefab), cause);
    }
}
