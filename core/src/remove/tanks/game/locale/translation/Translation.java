package remove.tanks.game.locale.translation;

import java.util.IllegalFormatException;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class Translation {
    private final String id;
    private final Map<String, String> entries;

    public Translation(String id, Map<String, String> entries) {
        this.id = id;
        this.entries = entries;
    }

    public String getId() {
        return id;
    }

    public boolean hasEntry(String key) {
        return entries.containsKey(key);
    }

    public String getEntry(String key) {
        if (!entries.containsKey(key)) {
            throw new EntryNotFoundException(key);
        }
        return entries.get(key);
    }

    public String getFormattedEntry(String key, Object... values) {
        if (!entries.containsKey(key)) {
            throw new EntryNotFoundException(key);
        }
        try {
            return String.format(entries.get(key), values);
        } catch (IllegalFormatException e) {
            throw new EntryFormattingException(entries.get(key), values);
        }
    }
}
