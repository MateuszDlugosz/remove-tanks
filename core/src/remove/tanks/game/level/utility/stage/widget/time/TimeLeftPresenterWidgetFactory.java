package remove.tanks.game.level.utility.stage.widget.time;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import remove.tanks.game.level.LevelProperty;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.level.utility.stage.widget.SubWidgetFactory;
import remove.tanks.game.level.utility.stage.widget.WidgetCreateException;
import remove.tanks.game.locale.Locale;
import remove.tanks.game.locale.translation.TranslationEntryKey;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class TimeLeftPresenterWidgetFactory implements SubWidgetFactory<TimeLeftPresenterWidget, TimeLeftPresenterWidgetPrefab> {
    @Override
    public TimeLeftPresenterWidget createWidget(TimeLeftPresenterWidgetPrefab prefab, Table table, ResourceRegistry registry) {
        try {
            return new TimeLeftPresenterWidget(
                    createTitleLabel(
                            registry.getResource(ResourceType.LocaleResource, Locale.class),
                            registry.getResource(ResourceType.UISkinResource, Skin.class)
                    ),
                    createValueLabel(
                            registry.getResource(ResourceType.LevelPropertiesResource, Properties.class),
                            registry.getResource(ResourceType.UISkinResource, Skin.class)
                    ),
                    createTimeFormatter()
            );
        } catch (Exception e) {
            throw new WidgetCreateException(prefab, e);
        }
    }

    private Label createTitleLabel(Locale locale, Skin skin) {
        return new Label(locale.getSelectedTranslation()
                .getEntry(TranslationEntryKey.GameLevelHudTimeLeft.getName()).toUpperCase(), skin);
    }

    private Label createValueLabel(Properties properties, Skin skin) {
        return new Label(new TimeFormatter().formatTime(
                properties.getFloat(LevelProperty.LevelTimeLeft.getName())), skin);
    }

    private TimeFormatter createTimeFormatter() {
        return new TimeFormatter();
    }

    @Override
    public Class<TimeLeftPresenterWidgetPrefab> getFactoryType() {
        return TimeLeftPresenterWidgetPrefab.class;
    }
}
