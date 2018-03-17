package remove.tanks.game.level.utility.stage.widget.property;

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
    public void update(float delta, ResourceRegistry registry) {
        titleLabel.setText(registry.getResource(ResourceType.LocaleResource, Locale.class)
                .getSelectedTranslation().getEntry(titleEntry.getName()).toUpperCase());
        valueLabel.setText(registry.getResource(ResourceType.LevelPropertiesResource, Properties.class)
                .getString(property.getName()));
    }
}
