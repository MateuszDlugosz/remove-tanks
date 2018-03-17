package remove.tanks.game.level.utility.stage.widget.property;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.LevelProperty;
import remove.tanks.game.level.utility.stage.widget.SubWidgetPrefabXmlReader;
import remove.tanks.game.level.utility.stage.widget.WidgetPrefabXmlReadException;
import remove.tanks.game.level.utility.stage.widget.WidgetType;
import remove.tanks.game.locale.translation.TranslationEntryKey;

/**
 * @author Mateusz Długosz
 */
public final class PropertyPresenterWidgetPrefabXmlReader implements SubWidgetPrefabXmlReader<PropertyPresenterWidgetPrefab> {
    private static final String TITLE_ENTRY_ELEMENT = "titleEntry";
    private static final String PROPERTY_ELEMENT = "property";

    @Override
    public PropertyPresenterWidgetPrefab readWidgetPrefab(XmlReader.Element element) {
        try {
            return new PropertyPresenterWidgetPrefab(
                    readTitleEntry(element),
                    readProperty(element)
            );
        } catch (Exception e) {
            throw new WidgetPrefabXmlReadException(element, e);
        }
    }

    private TranslationEntryKey readTitleEntry(XmlReader.Element element) {
        return TranslationEntryKey.valueOf(element.getChildByName(TITLE_ENTRY_ELEMENT).getText().trim());
    }

    private LevelProperty readProperty(XmlReader.Element element) {
        return LevelProperty.valueOf(element.getChildByName(PROPERTY_ELEMENT).getText().trim());
    }

    @Override
    public WidgetType getReaderType() {
        return WidgetType.PropertyPresenterWidget;
    }
}
