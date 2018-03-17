package remove.tanks.game.locale;

import remove.tanks.game.locale.translation.TranslationRepository;
import remove.tanks.game.locale.translation.TranslationStorage;
import remove.tanks.game.locale.translation.TranslationStorageFactory;

/**
 * @author Mateusz Długosz
 */
public final class LocaleFactory {
    private final TranslationStorageFactory translationStorageFactory;

    public LocaleFactory(TranslationStorageFactory translationStorageFactory) {
        this.translationStorageFactory = translationStorageFactory;
    }

    public Locale createLocale(TranslationRepository repository, String initialTranslationId) {
        try {
            return new Locale(createTranslationStorage(repository), initialTranslationId);
        } catch (Exception e) {
            throw new LocaleCreateException(e);
        }
    }

    private TranslationStorage createTranslationStorage(TranslationRepository repository) {
        return translationStorageFactory.createTranslationStorage(repository);
    }
}
