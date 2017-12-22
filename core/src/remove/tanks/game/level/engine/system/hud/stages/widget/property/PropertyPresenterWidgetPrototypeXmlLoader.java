package remove.tanks.game.level.engine.system.hud.stages.widget.property;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.constant.LevelProperty;
import remove.tanks.game.level.engine.system.hud.stages.widget.RegistrableWidgetPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.hud.stages.widget.WidgetPrototypeXmlLoadException;
import remove.tanks.game.level.engine.system.hud.stages.widget.WidgetType;
import remove.tanks.game.locale.translation.constant.TranslationEntryKey;

/**
 * @author Mateusz Długosz
 */
public final class PropertyPresenterWidgetPrototypeXmlLoader
        implements RegistrableWidgetPrototypeXmlLoader<PropertyPresenterWidgetPrototype>
{
    private static final String TITLE_ENTRY_ELEMENT = "titleEntry";
    private static final String PROPERTY_ELEMENT = "property";

    @Override
    public PropertyPresenterWidgetPrototype loadWidgetPrototype(XmlReader.Element element) {
        try {
            return new PropertyPresenterWidgetPrototype(
                    loadTitleEntry(element),
                    loadProperty(element)
            );
        } catch (Exception e) {
            throw new WidgetPrototypeXmlLoadException(element, e);
        }
    }

    private TranslationEntryKey loadTitleEntry(XmlReader.Element element) {
        return TranslationEntryKey.valueOf(element.getChildByName(TITLE_ENTRY_ELEMENT).getText().trim());
    }

    private LevelProperty loadProperty(XmlReader.Element element) {
        return LevelProperty.valueOf(element.getChildByName(PROPERTY_ELEMENT).getText().trim());
    }

    @Override
    public WidgetType getLoaderType() {
        return WidgetType.PropertyPresenterWidget;
    }
}
