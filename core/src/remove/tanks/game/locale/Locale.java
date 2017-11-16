package remove.tanks.game.locale;

import remove.tanks.game.locale.translation.Translation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class Locale {
    private final List<Translation> translations = new ArrayList<>();
    private int selectedTranslationIndex;

    public Locale(Translation[] translations) {
        if (translations.length == 0) {
            throw new IllegalArgumentException("Locale requires at least one translation.");
        }
        this.translations.addAll(Arrays.asList(translations));
        this.selectedTranslationIndex = 0;
    }

    public void selectPreviousTranslation() {
        if (selectedTranslationIndex == 0 && translations.size() > 1) {
            selectedTranslationIndex = translations.size() - 1;
        } else {
            selectedTranslationIndex--;
        }
    }

    public void selectNextTranslation() {
        if (selectedTranslationIndex == translations.size() - 1) {
            selectedTranslationIndex = 0;
        } else {
            selectedTranslationIndex++;
        }
    }

    public Translation getTranslation() {
        return translations.get(selectedTranslationIndex);
    }
}
