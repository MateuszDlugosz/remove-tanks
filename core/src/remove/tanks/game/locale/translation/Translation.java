package remove.tanks.game.locale.translation;

import java.util.IllegalFormatException;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class Translation {
    private final Map<String, String> entries;

    public Translation(Map<String, String> entries) {
        this.entries = entries;
    }

    public String getFormattedEntry(String key, Object... values) {
        if (!entries.containsKey(key)) {
            throw new EntryNotFoundException(key);
        }
        try {
            return String.format(getEntry(key), values);
        } catch (IllegalFormatException e) {
            throw new EntryFormattingException(entries.get(key), values);
        }
    }

    public String getEntry(String key) {
        if (!entries.containsKey(key)) {
            throw new EntryNotFoundException(key);
        }
        return entries.get(key);
    }
}
