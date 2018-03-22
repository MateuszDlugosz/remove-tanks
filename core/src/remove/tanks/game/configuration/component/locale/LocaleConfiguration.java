package remove.tanks.game.configuration.component.locale;

import com.badlogic.gdx.Preferences;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.locale.Locale;
import remove.tanks.game.locale.LocaleFactory;
import remove.tanks.game.locale.translation.TranslationRepository;
import remove.tanks.game.locale.translation.TranslationStorageFactory;
import remove.tanks.game.utility.preferences.PreferenceName;

/**
 * @author Mateusz Długosz
 */
public final class LocaleConfiguration {
    @ComponentName("Locale")
    public static final class LocaleSupplier extends ComponentSupplier<Locale> {
        @Override
        public Locale supplyComponent() {
            return getContext().getComponent("LocaleFactory", LocaleFactory.class)
                    .createLocale(
                            getContext().getComponent("TranslationRepository", TranslationRepository.class),
                            getContext().getComponent("Preferences", Preferences.class)
                                    .getString(PreferenceName.LanguagePreference.getName())
                    );
        }
    }

    @ComponentName("LocaleFactory")
    public static final class LocaleFactorySupplier extends ComponentSupplier<LocaleFactory> {
        @Override
        public LocaleFactory supplyComponent() {
            return new LocaleFactory(
                    getContext().getComponent("TranslationStorageFactory", TranslationStorageFactory.class)
            );
        }
    }
}
