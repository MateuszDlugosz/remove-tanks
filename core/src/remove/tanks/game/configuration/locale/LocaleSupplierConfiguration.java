package remove.tanks.game.configuration.locale;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.locale.Locale;
import remove.tanks.game.locale.translation.Translation;
import remove.tanks.game.locale.translation.TranslationXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class LocaleSupplierConfiguration {
    @ComponentName("Locale")
    public static final class LocaleSupplier extends ComponentSupplier<Locale> {
        @Override
        public Locale supplyComponent() {
            return new Locale(
                    new Translation[] {
                            getContext().getComponent("TranslationXmlLoader", TranslationXmlLoader.class)
                                    .loadTranslation("locales/translations/_en.xml"),
                            getContext().getComponent("TranslationXmlLoader", TranslationXmlLoader.class)
                                    .loadTranslation("locales/translations/_pl.xml")
                    }
            );
        }
    }

    @ComponentName("TranslationXmlLoader")
    public static final class TranslationXmlLoaderSupplier extends ComponentSupplier<TranslationXmlLoader> {
        @Override
        public TranslationXmlLoader supplyComponent() {
            return new TranslationXmlLoader(
                    getContext().getComponent("XmlReader", XmlReader.class)
            );
        }
    }
}
