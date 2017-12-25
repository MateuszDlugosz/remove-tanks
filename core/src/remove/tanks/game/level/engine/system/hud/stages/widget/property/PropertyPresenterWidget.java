package remove.tanks.game.level.engine.system.hud.stages.widget.property;

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
public final class PropertyPresenterWidget implements Widget {
    private final TranslationEntryKey titleEntry;
    private final LevelProperty property;
    private final Label titleLabel;
    private final Label valueLabel;

    public PropertyPresenterWidget(
            TranslationEntryKey titleEntry,
            LevelProperty property,
            Label titleLabel,
            Label valueLabel
    ) {
        this.titleEntry = titleEntry;
        this.property = property;
        this.titleLabel = titleLabel;
        this.valueLabel = valueLabel;
    }

    public TranslationEntryKey getTitleEntry() {
        return titleEntry;
    }

    public LevelProperty getProperty() {
        return property;
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
        titleLabel.setText(resourceRegistry.getResource(LevelResource.Locale.toString(), Locale.class)
                .getTranslation().getEntry(titleEntry.getName()).toUpperCase());
        valueLabel.setText(resourceRegistry.getResource(LevelResource.Properties.toString(), Properties.class)
                .getString(property.getName()).toUpperCase());
    }
}
