package remove.tanks.game.configuration.component.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.application.context.configuration.ConfigurationOption;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.graphics.sprite.SpriteFactory;
import remove.tanks.game.graphics.sprite.SpritePrefabXmlReader;
import remove.tanks.game.level.LevelSequenceXmlReader;
import remove.tanks.game.level.mode.operation.*;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class OperationConfiguration {
    @ComponentName("OperationPrefabXmlReader")
    public static final class OperationPrefabXmlReaderSupplier extends ComponentSupplier<OperationPrefabXmlReader> {
        @Override
        public OperationPrefabXmlReader supplyComponent() {
            return new OperationPrefabXmlReader(
                    getContext().getComponent("XmlReader", XmlReader.class),
                    getContext().getComponent("SpritePrefabXmlReader", SpritePrefabXmlReader.class),
                    getContext().getComponent("LevelSequenceXmlReader", LevelSequenceXmlReader.class)
            );
        }
    }

    @ComponentName("OperationFactory")
    public static final class OperationFactorySupplier extends ComponentSupplier<OperationFactory> {
        @Override
        public OperationFactory supplyComponent() {
            return new OperationFactory(
                    getContext().getComponent("SpriteFactory", SpriteFactory.class)
            );
        }
    }

    @ComponentName("OperationPrefabFilenameRepositoryXmlReader")
    public static final class OperationPrefabFilenameRepositoryXmlReaderSupplier extends ComponentSupplier<OperationPrefabFilenameRepositoryXmlReader> {
        @Override
        public OperationPrefabFilenameRepositoryXmlReader supplyComponent() {
            return new OperationPrefabFilenameRepositoryXmlReader(
                    getContext().getComponent("XmlReader", XmlReader.class)
            );
        }
    }

    @ComponentName("OperationPrefabFilenameRepository")
    public static final class OperationPrefabFilenameRepositorySupplier extends ComponentSupplier<OperationPrefabFilenameRepository> {
        @Override
        public OperationPrefabFilenameRepository supplyComponent() {
            return getContext().getComponent("OperationPrefabFilenameRepositoryXmlReader",
                    OperationPrefabFilenameRepositoryXmlReader.class)
                    .readOperationPrefabFilenameRepository(
                            Gdx.files.internal(
                                    getContext().getConfiguration().getOption(
                                            ConfigurationOption.GameOperationPrefabFilenameRepositoryFilename.getName()
                                    )
                            )
                    );
        }
    }

    @ComponentName("OperationStorageFactory")
    public static final class OperationStorageFactorySupplier extends ComponentSupplier<OperationStorageFactory> {
        @Override
        public OperationStorageFactory supplyComponent() {
            return new OperationStorageFactory(
                    getContext().getComponent("OperationPrefabXmlReader", OperationPrefabXmlReader.class),
                    getContext().getComponent("OperationFactory", OperationFactory.class)
            );
        }
    }

    @ComponentName("OperationStorage")
    public static final class OperationStorageSupplier extends ComponentSupplier<OperationStorage> {
        @Override
        public OperationStorage supplyComponent() {
            return getContext().getComponent("OperationStorageFactory", OperationStorageFactory.class)
                    .createOperationStorage(
                            getContext().getComponent("OperationPrefabFilenameRepository",
                                    OperationPrefabFilenameRepository.class),
                            getContext().getComponent("MainAssetStorage", AssetStorage.class),
                            getContext().getComponent("UIScale", Scale.class)
                    );
        }
    }
}
