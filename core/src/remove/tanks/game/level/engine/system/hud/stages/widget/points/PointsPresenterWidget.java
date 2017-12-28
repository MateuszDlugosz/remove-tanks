package remove.tanks.game.level.engine.system.hud.stages.widget.points;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import remove.tanks.game.level.constant.LevelProperty;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.system.hud.stages.widget.Widget;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.locale.Locale;
import remove.tanks.game.locale.translation.constant.TranslationEntryKey;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class PointsPresenterWidget implements Widget {
    private final Label titleLabel;
    private final Label valueLabel;

    public PointsPresenterWidget(Label titleLabel, Label valueLabel) {
        this.titleLabel = titleLabel;
        this.valueLabel = valueLabel;
    }

    @Override
    public Label getTitleLabel() {
        return titleLabel;
    }

    @Override
    public Label getValueLabel() {
        return valueLabel;
    }

    @Override
    public void update(float delta, ResourceRegistry resourceRegistry) {
        Locale locale = resourceRegistry.getResource(LevelResource.Locale.toString(), Locale.class);
        Properties properties = resourceRegistry.getResource(LevelResource.Properties.toString(), Properties.class);
        titleLabel.setText(locale.getTranslation()
                .getFormattedEntry(
                        TranslationEntryKey.GameLevelHudPoints.getName(),
                        properties.getString(LevelProperty.LevelPointsMultiplier.getName())
                ).toUpperCase());
        valueLabel.setText(properties.getString(LevelProperty.LevelPoints.getName()).toUpperCase());
    }
}
