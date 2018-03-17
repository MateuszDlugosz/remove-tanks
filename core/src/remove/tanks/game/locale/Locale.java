package remove.tanks.game.locale;

import remove.tanks.game.locale.translation.Translation;
import remove.tanks.game.locale.translation.TranslationStorage;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class Locale {
    private final TranslationStorage translationStorage;
    private String selectedTranslationId;

    public Locale(TranslationStorage translationStorage, String selectedTranslationId) {
        this.translationStorage = translationStorage;
        this.selectedTranslationId = selectedTranslationId;
    }

    public String getSelectedTranslationId() {
        return selectedTranslationId;
    }

    public Translation getSelectedTranslation() {
        return translationStorage.getTranslation(selectedTranslationId);
    }

    public void selectNextTranslation() {
        List<String> translationsIds = new ArrayList<>(translationStorage.getTranslationsKeys());
        int selectedIndex = translationsIds.indexOf(selectedTranslationId);
        if (selectedIndex + 1 > translationsIds.size() - 1) {
            selectedTranslationId = translationsIds.get(0);
        } else {
            selectedTranslationId = translationsIds.get(selectedIndex + 1);
        }
    }

    public void selectPreviousTranslation() {
        List<String> translationsIds = new ArrayList<>(translationStorage.getTranslationsKeys());
        int selectedIndex = translationsIds.indexOf(selectedTranslationId);
        if (selectedIndex - 1 < 0) {
            selectedTranslationId = translationsIds.get(translationsIds.size() - 1);
        } else {
            selectedTranslationId = translationsIds.get(selectedIndex - 1);
        }
    }
}
