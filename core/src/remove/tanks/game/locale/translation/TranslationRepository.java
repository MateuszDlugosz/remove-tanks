package remove.tanks.game.locale.translation;

import java.util.Map;
import java.util.Set;

/**
 * @author Mateusz Długosz
 */
public final class TranslationRepository {
    private final Map<String, String> translationFilenames;

    public TranslationRepository(Map<String, String> translationFilenames) {
        this.translationFilenames = translationFilenames;
    }

    public String getTranslationFilename(String id) {
        if (!translationFilenames.containsKey(id)) {
            throw new TranslationIdNotFoundException(id);
        }
        return translationFilenames.get(id);
    }

    public Set<String> getTranslationsIds() {
        return translationFilenames.keySet();
    }
}
