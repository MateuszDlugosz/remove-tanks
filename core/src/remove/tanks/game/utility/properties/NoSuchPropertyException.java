package remove.tanks.game.utility.properties;

/**
 * @author Mateusz Długosz
 */
public final class NoSuchPropertyException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Property %s not found.";

    public NoSuchPropertyException(String key) {
        super(String.format(MESSAGE_TEMPLATE, key));
    }
}
