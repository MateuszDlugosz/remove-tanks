package remove.tanks.game.configuration.component.utility;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.application.context.configuration.ConfigurationOption;
import remove.tanks.game.utility.preferences.PreferenceName;

/**
 * @author Mateusz Długosz
 */
public final class PreferencesConfiguration {
    @ComponentName("Preferences")
    public static final class PreferencesSupplier extends ComponentSupplier<Preferences> {
        @Override
        public Preferences supplyComponent() {
            Preferences preferences = Gdx.app.getPreferences(
                    getContext().getConfiguration().getOption(ConfigurationOption.GamePreferencesFilename.getName()));
            if (!preferences.contains(PreferenceName.LanguagePreference.getName())) {
                preferences.putString(
                        PreferenceName.LanguagePreference.getName(),
                        getContext().getConfiguration().getOption(ConfigurationOption.GameDefaultLanguage.getName())
                );
            }

            return preferences;
        }
    }
}
