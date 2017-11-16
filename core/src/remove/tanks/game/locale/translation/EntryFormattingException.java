package remove.tanks.game.locale.translation;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class EntryFormattingException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Entry '%s' cannot be formatted by %s parameters.";

    public EntryFormattingException(String entry, Object[] parameters) {
        super(String.format(
                MESSAGE_TEMPLATE,
                entry,
                Arrays.stream(parameters)
                        .map(Object::toString)
                        .collect(Collectors.toList())
                        .toString()
        ));
    }
}
