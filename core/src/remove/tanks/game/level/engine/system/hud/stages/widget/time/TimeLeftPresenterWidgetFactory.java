package remove.tanks.game.level.engine.system.hud.stages.widget.time;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import remove.tanks.game.level.constant.LevelProperty;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.system.hud.stages.widget.RegistrableWidgetFactory;
import remove.tanks.game.level.engine.system.hud.stages.widget.WidgetCreateException;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.locale.Locale;
import remove.tanks.game.locale.translation.constant.TranslationEntryKey;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class TimeLeftPresenterWidgetFactory
        implements RegistrableWidgetFactory<TimeLeftPresenterWidget, TimeLeftPresenterWidgetPrototype>
{
    @Override
    public TimeLeftPresenterWidget createWidget(TimeLeftPresenterWidgetPrototype prototype, Table table, ResourceRegistry resourceRegistry) {
        try {
            return new TimeLeftPresenterWidget(
                    createTitleLabel(
                            resourceRegistry.getResource(LevelResource.Locale.toString(), Locale.class),
                            resourceRegistry.getResource(LevelResource.UiSkin.toString(), Skin.class)
                    ),
                    createValueLabel(
                            resourceRegistry.getResource(LevelResource.Properties.toString(), Properties.class),
                            resourceRegistry.getResource(LevelResource.UiSkin.toString(), Skin.class)
                    ),
                    createTimeFormatter()
            );
        } catch (Exception e) {
            throw new WidgetCreateException(prototype, e);
        }
    }

    private Label createTitleLabel(Locale locale, Skin skin) {
        return new Label(
                locale.getTranslation().getEntry(TranslationEntryKey.GameLevelHudTimeLeft.getName()).toUpperCase(),
                skin
        );
    }

    private Label createValueLabel(Properties properties, Skin skin) {
        return new Label(
                new TimeFormatter().formatTime(properties.getFloat(LevelProperty.LevelTimeLeft.getName())),
                skin
        );
    }

    private TimeFormatter createTimeFormatter() {
        return new TimeFormatter();
    }

    @Override
    public Class<TimeLeftPresenterWidgetPrototype> getFactoryType() {
        return TimeLeftPresenterWidgetPrototype.class;
    }
}
