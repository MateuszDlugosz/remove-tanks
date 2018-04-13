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
import remove.tanks.game.level.mode.arena.*;
import remove.tanks.game.level.mode.campaign.*;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class ArenaConfiguration {
    @ComponentName("ArenaFactory")
    public static final class ArenaFactorySupplier extends ComponentSupplier<ArenaFactory> {
        @Override
        public ArenaFactory supplyComponent() {
            return new ArenaFactory(
                    getContext().getComponent("SpriteFactory", SpriteFactory.class)
            );
        }
    }

    @ComponentName("ArenaPrefabXmlReader")
    public static final class ArenaPrefabXmlReaderSupplier extends ComponentSupplier<ArenaPrefabXmlReader> {
        @Override
        public ArenaPrefabXmlReader supplyComponent() {
            return new ArenaPrefabXmlReader(
                    getContext().getComponent("XmlReader", XmlReader.class),
                    getContext().getComponent("SpritePrefabXmlReader", SpritePrefabXmlReader.class),
                    getContext().getComponent("LevelSequenceXmlReader", LevelSequenceXmlReader.class)
            );
        }
    }

    @ComponentName("ArenaPrefabFilenameRepositoryXmlReader")
    public static final class ArenaPrefabFilenameRepositoryXmlReaderSupplier extends ComponentSupplier<ArenaPrefabFilenameRepositoryXmlReader> {
        @Override
        public ArenaPrefabFilenameRepositoryXmlReader supplyComponent() {
            return new ArenaPrefabFilenameRepositoryXmlReader(
                    getContext().getComponent("XmlReader", XmlReader.class)
            );
        }
    }

    @ComponentName("ArenaStorageFactory")
    public static final class ArenaPrefabStorageFactorySupplier extends ComponentSupplier<ArenaStorageFactory> {
        @Override
        public ArenaStorageFactory supplyComponent() {
            return new ArenaStorageFactory(
                    getContext().getComponent("ArenaPrefabXmlReader", ArenaPrefabXmlReader.class),
                    getContext().getComponent("ArenaFactory", ArenaFactory.class)
            );
        }
    }

    @ComponentName("ArenaPrefabFilenameRepository")
    public static final class ArenaPrefabFilenameRepositorySupplier extends ComponentSupplier<ArenaPrefabFilenameRepository> {
        @Override
        public ArenaPrefabFilenameRepository supplyComponent() {
            return getContext().getComponent("ArenaPrefabFilenameRepositoryXmlReader",
                    ArenaPrefabFilenameRepositoryXmlReader.class).readArenaPrefabFilenameRepository(
                    Gdx.files.internal(getContext().getConfiguration()
                            .getOption(ConfigurationOption.GameArenaPrefabFilenameRepositoryFilename.getName()))
            );
        }
    }

    @ComponentName("ArenaStorage")
    public static final class ArenaPrefabStorageSupplier extends ComponentSupplier<ArenaStorage> {
        @Override
        public ArenaStorage supplyComponent() {
            return getContext().getComponent("ArenaStorageFactory", ArenaStorageFactory.class)
                    .createArenaStorage(
                            getContext().getComponent("ArenaPrefabFilenameRepository",
                                    ArenaPrefabFilenameRepository.class),
                            getContext().getComponent("MainAssetStorage", AssetStorage.class),
                            getContext().getComponent("UIScale", Scale.class)
                    );
        }
    }
}
