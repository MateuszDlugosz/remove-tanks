package remove.tanks.game.locale.translation;

import com.badlogic.gdx.Gdx;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class TranslationStorageFactory {
    private final TranslationXmlReader translationXmlReader;

    public TranslationStorageFactory(TranslationXmlReader translationXmlReader) {
        this.translationXmlReader = translationXmlReader;
    }

    public TranslationStorage createTranslationStorage(TranslationRepository repository) {
        try {
            return new TranslationStorage(createTranslations(repository));
        } catch (Exception e) {
            throw new TranslationStorageCreateException(e);
        }
    }

    private Map<String, Translation> createTranslations(TranslationRepository repository) {
        return repository.getTranslationsIds().stream()
                .collect(Collectors.toMap(
                        id -> id,
                        id -> translationXmlReader.readTranslation(Gdx.files.internal(repository.getTranslationFilename(id)))
                ));
    }
}
