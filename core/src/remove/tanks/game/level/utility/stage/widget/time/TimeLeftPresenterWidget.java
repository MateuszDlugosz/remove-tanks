package remove.tanks.game.level.utility.stage.widget.time;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import remove.tanks.game.level.LevelProperty;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.level.utility.stage.widget.Widget;
import remove.tanks.game.locale.Locale;
import remove.tanks.game.locale.translation.TranslationEntryKey;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class TimeLeftPresenterWidget implements Widget {
    private final Label titleLabel;
    private final Label valueLabel;
    private final TimeFormatter timeFormatter;

    public TimeLeftPresenterWidget(Label titleLabel, Label valueLabel, TimeFormatter timeFormatter) {
        this.titleLabel = titleLabel;
        this.valueLabel = valueLabel;
        this.timeFormatter = timeFormatter;
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
        Locale locale = resourceRegistry.getResource(ResourceType.LocaleResource, Locale.class);
        Properties properties = resourceRegistry.getResource(ResourceType.LevelPropertiesResource, Properties.class);

        titleLabel.setText(locale.getSelectedTranslation()
                .getEntry(TranslationEntryKey.GameLevelHudTimeLeft.getName()).toUpperCase());
        valueLabel.setText(timeFormatter.formatTime(
                properties.getFloat(LevelProperty.LevelTimeLeft.getName())).toUpperCase()
        );
    }
}
