package remove.tanks.game.level.engine.system.hud.stages.widget.property;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.constant.LevelProperty;
import remove.tanks.game.level.engine.system.hud.stages.widget.WidgetPrototype;
import remove.tanks.game.locale.translation.constant.TranslationEntryKey;

/**
 * @author Mateusz Długosz
 */
public final class PropertyPresenterWidgetPrototype implements WidgetPrototype {
    private final TranslationEntryKey titleEntry;
    private final LevelProperty property;

    public PropertyPresenterWidgetPrototype(TranslationEntryKey titleEntry, LevelProperty property) {
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
