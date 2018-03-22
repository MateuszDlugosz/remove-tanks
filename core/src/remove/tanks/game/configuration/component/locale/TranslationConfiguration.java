package remove.tanks.game.configuration.component.locale;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.application.context.configuration.ConfigurationOption;
import remove.tanks.game.locale.translation.TranslationRepository;
import remove.tanks.game.locale.translation.TranslationRepositoryXmlReader;
import remove.tanks.game.locale.translation.TranslationStorageFactory;
import remove.tanks.game.locale.translation.TranslationXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class TranslationConfiguration {
    @ComponentName("TranslationStorageFactory")
    public static final class TranslationStorageFactorySupplier extends ComponentSupplier<TranslationStorageFactory> {
        @Override
        public TranslationStorageFactory supplyComponent() {
            return new TranslationStorageFactory(
                    getContext().getComponent("TranslationXmlReader", TranslationXmlReader.class)
            );
        }
    }

    @ComponentName("TranslationXmlReader")
    public static final class TranslationXmlReaderSupplier extends ComponentSupplier<TranslationXmlReader> {
        @Override
        public TranslationXmlReader supplyComponent() {
            return new TranslationXmlReader(
                    getContext().getComponent("XmlReader", XmlReader.class)
            );
        }
    }

    @ComponentName("TranslationRepositoryXmlReader")
    public static final class TranslationRepositoryXmlReaderSupplier extends ComponentSupplier<TranslationRepositoryXmlReader> {
        @Override
        public TranslationRepositoryXmlReader supplyComponent() {
            return new TranslationRepositoryXmlReader(
                    getContext().getComponent("XmlReader", XmlReader.class)
            );
        }
    }

    @ComponentName("TranslationRepository")
    public static final class TranslationRepositorySupplier extends ComponentSupplier<TranslationRepository> {
        @Override
        public TranslationRepository supplyComponent() {
            return getContext().getComponent("TranslationRepositoryXmlReader", TranslationRepositoryXmlReader.class)
                    .readTranslationRepository(Gdx.files.internal(
                            getContext().getConfiguration().getOption(ConfigurationOption.GameTranslationRepositoryFilename.getName())
                    ));
        }
    }
}
