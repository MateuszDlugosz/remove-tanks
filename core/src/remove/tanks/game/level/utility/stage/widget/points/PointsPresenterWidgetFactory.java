package remove.tanks.game.level.utility.stage.widget.points;

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
public final class PointsPresenterWidgetFactory implements SubWidgetFactory<PointsPresenterWidget, PointsPresenterWidgetPrefab> {
    @Override
    public PointsPresenterWidget createWidget(PointsPresenterWidgetPrefab prefab, Table table, ResourceRegistry registry) {
        try {
            return new PointsPresenterWidget(
                    createTitleLabel(
                            registry.getResource(ResourceType.LocaleResource, Locale.class),
                            registry.getResource(ResourceType.LevelPropertiesResource, Properties.class),
                            registry.getResource(ResourceType.UISkinResource, Skin.class)
                    ),
                    createValueLabel(
                            registry.getResource(ResourceType.LevelPropertiesResource, Properties.class),
                            registry.getResource(ResourceType.UISkinResource, Skin.class)
                    )
            );
        } catch (Exception e) {
            throw new WidgetCreateException(prefab, e);
        }
    }

    private Label createTitleLabel(Locale locale, Properties properties, Skin skin) {
        return new Label(locale.getSelectedTranslation().getFormattedEntry(
                TranslationEntryKey.GameLevelHudPoints.getName(),
                properties.getString(LevelProperty.LevelPointsMultiplier.getName())
        ).toUpperCase(), skin);
    }

    private Label createValueLabel(Properties properties, Skin skin) {
        return new Label(properties.getString(LevelProperty.LevelPoints.getName()), skin);
    }

    @Override
    public Class<PointsPresenterWidgetPrefab> getFactoryType() {
        return PointsPresenterWidgetPrefab.class;
    }
}
