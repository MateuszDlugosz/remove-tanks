package remove.tanks.game.level.utility.stage.widget.property;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.LevelProperty;
import remove.tanks.game.level.utility.stage.widget.WidgetPrefab;
import remove.tanks.game.locale.translation.TranslationEntryKey;

/**
 * @author Mateusz Długosz
 */
public final class PropertyPresenterWidgetPrefab extends WidgetPrefab {
    private final TranslationEntryKey titleEntry;
    private final LevelProperty property;

    public PropertyPresenterWidgetPrefab(TranslationEntryKey titleEntry, LevelProperty property) {
        this.titleEntry = titleEntry;
        this.property = property;
    }

    public TranslationEntryKey getTitleEntry() {
        return titleEntry;
    }

    public LevelProperty getProperty() {
        return property;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("titleEntry", titleEntry)
                .add("property", property)
                .toString();
    }
}
