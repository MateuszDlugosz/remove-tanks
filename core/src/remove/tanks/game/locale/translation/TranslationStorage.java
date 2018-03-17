package remove.tanks.game.locale.translation;

import java.util.Map;
import java.util.Set;

/**
 * @author Mateusz Długosz
 */
public final class TranslationStorage {
    private final Map<String, Translation> translations;

    public TranslationStorage(Map<String, Translation> translations) {
        this.translations = translations;
    }

    public Translation getTranslation(String id) {
        if (!translations.containsKey(id)) {
            throw new TranslationNotFoundException(id);
        }
        return translations.get(id);
    }

    public Set<String> getTranslationsKeys() {
        return translations.keySet();
    }
}
