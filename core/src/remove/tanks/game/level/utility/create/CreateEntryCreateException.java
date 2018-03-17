package remove.tanks.game.level.utility.create;

/**
 * @author Mateusz Długosz
 */
public final class CreateEntryCreateException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot create create entry from prefab %s.";

    public CreateEntryCreateException(CreateEntryPrefab prefab, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, prefab), cause);
    }
}
