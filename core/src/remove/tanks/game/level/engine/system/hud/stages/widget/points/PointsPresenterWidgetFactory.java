package remove.tanks.game.level.engine.system.hud.stages.widget.points;

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
public final class PointsPresenterWidgetFactory
        implements RegistrableWidgetFactory<PointsPresenterWidget, PointsPresenterWidgetPrototype>
{
    @Override
    public PointsPresenterWidget createWidget(PointsPresenterWidgetPrototype prototype, Table table, ResourceRegistry resourceRegistry) {
        try {
            return new PointsPresenterWidget(
                    createTitleLabel(
                            resourceRegistry.getResource(LevelResource.Locale.toString(), Locale.class),
                            resourceRegistry.getResource(LevelResource.Properties.toString(), Properties.class),
                            resourceRegistry.getResource(LevelResource.UiSkin.toString(), Skin.class)
                    ),
                    createValueLabel(
                            resourceRegistry.getResource(LevelResource.Properties.toString(), Properties.class),
                            resourceRegistry.getResource(LevelResource.UiSkin.toString(), Skin.class)
                    )
            );
        } catch (Exception e) {
            throw new WidgetCreateException(prototype, e);
        }
    }

    private Label createTitleLabel(Locale locale, Properties properties, Skin skin) {
        return new Label(
                locale.getTranslation().getFormattedEntry(
                        TranslationEntryKey.GameLevelHudPoints.getName(),
                        properties.getString(LevelProperty.LevelPointsMultiplier.getName())
                ).toUpperCase(),
                skin
        );
    }

    private Label createValueLabel(Properties properties, Skin skin) {
        return new Label(
                properties.getString(LevelProperty.LevelPoints.getName()),
                skin
        );
    }

    @Override
    public Class<PointsPresenterWidgetPrototype> getFactoryType() {
        return PointsPresenterWidgetPrototype.class;
    }
}
