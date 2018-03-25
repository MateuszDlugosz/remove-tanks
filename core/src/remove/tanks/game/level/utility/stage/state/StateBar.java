package remove.tanks.game.level.utility.stage.state;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import remove.tanks.game.level.LevelProperty;
import remove.tanks.game.level.LevelState;
import remove.tanks.game.locale.Locale;
import remove.tanks.game.utility.properties.Properties;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class StateBar {
    private static final String TRANSLATION_ENTRY_TEMPLATE = "game.level.state.%s";
    private static final String EMPTY_STATE_TEMPLATE = "";

    private final Label label;
    private final List<LevelState> displayableStates;
    private final Properties properties;
    private final Locale locale;

    public StateBar(
            Label label,
            List<LevelState> displayableStates,
            Properties properties,
            Locale locale
    ) {
        this.label = label;
        this.displayableStates = displayableStates;
        this.properties = properties;
        this.locale = locale;
    }

    public Label getLabel() {
        return label;
    }

    public void update() {
        if (displayableStates.contains(
                LevelState.valueOf(properties.getString(LevelProperty.LevelState.getName()))
        )) {
            label.setText(locale.getSelectedTranslation().getEntry(
                    String.format(
                            TRANSLATION_ENTRY_TEMPLATE,
                            properties.getString(LevelProperty.LevelState.getName()).toLowerCase()
                    )
            ).toUpperCase());
        } else {
            label.setText(EMPTY_STATE_TEMPLATE);
        }
    }
}
