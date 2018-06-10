package remove.tanks.game.configuration.component.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.application.context.configuration.ConfigurationOption;
import remove.tanks.game.level.LevelSequenceXmlReader;
import remove.tanks.game.level.mode.campaign.*;

/**
 * @author Mateusz Długosz
 */
public final class CampaignConfiguration {
    @ComponentName("CampaignFactory")
    public static final class CampaignFactorySupplier extends ComponentSupplier<CampaignFactory> {
        @Override
        public CampaignFactory supplyComponent() {
            return new CampaignFactory();
        }
    }

    @ComponentName("CampaignPrefabXmlReader")
    public static final class CampaignPrefabXmlReaderSupplier extends ComponentSupplier<CampaignPrefabXmlReader> {
        @Override
        public CampaignPrefabXmlReader supplyComponent() {
            return new CampaignPrefabXmlReader(
                    getContext().getComponent("XmlReader", XmlReader.class),
                    getContext().getComponent("LevelSequenceXmlReader", LevelSequenceXmlReader.class)
            );
        }
    }

    @ComponentName("CampaignPrefabFilenameRepositoryXmlReader")
    public static final class CampaignPrefabFilenameRepositoryXmlReaderSupplier extends ComponentSupplier<CampaignPrefabFilenameRepositoryXmlReader> {
        @Override
        public CampaignPrefabFilenameRepositoryXmlReader supplyComponent() {
            return new CampaignPrefabFilenameRepositoryXmlReader(
                    getContext().getComponent("XmlReader", XmlReader.class)
            );
        }
    }

    @ComponentName("CampaignStorageFactory")
    public static final class CampaignPrefabStorageFactorySupplier extends ComponentSupplier<CampaignStorageFactory> {
        @Override
        public CampaignStorageFactory supplyComponent() {
            return new CampaignStorageFactory(
                    getContext().getComponent("CampaignPrefabXmlReader", CampaignPrefabXmlReader.class),
                    getContext().getComponent("CampaignFactory", CampaignFactory.class)
            );
        }
    }

    @ComponentName("CampaignPrefabFilenameRepository")
    public static final class CampaignPrefabFilenameRepositorySupplier extends ComponentSupplier<CampaignPrefabFilenameRepository> {
        @Override
        public CampaignPrefabFilenameRepository supplyComponent() {
            return getContext().getComponent("CampaignPrefabFilenameRepositoryXmlReader",
                    CampaignPrefabFilenameRepositoryXmlReader.class).readCampaignPrefabRepository(
                    Gdx.files.internal(getContext().getConfiguration()
                            .getOption(ConfigurationOption.GameCampaignPrefabFilenameRepositoryFilename.getName()))
            );
        }
    }

    @ComponentName("CampaignStorage")
    public static final class CampaignPrefabStorageSupplier extends ComponentSupplier<CampaignStorage> {
        @Override
        public CampaignStorage supplyComponent() {
            return getContext().getComponent("CampaignStorageFactory", CampaignStorageFactory.class)
                    .createCampaignPrefabStorage(
                            getContext().getComponent("CampaignPrefabFilenameRepository",
                                    CampaignPrefabFilenameRepository.class)
                    );
        }
    }
}
