package remove.tanks.game.level.utility.timeline;

/**
 * @author Mateusz Długosz
 */
public final class TimelineCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create timeline from prefab %s.";

    public TimelineCreateException(TimelinePrefab prefab, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prefab), cause);
    }
}
