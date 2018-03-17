package remove.tanks.game.utility.properties;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class NoSuchPropertiesKeysValidationException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Properties keys not found: %s.";

    public NoSuchPropertiesKeysValidationException(List<String> keys) {
        super(String.format(MESSAGE_TEMPLATE, keys.toString()));
    }
}
