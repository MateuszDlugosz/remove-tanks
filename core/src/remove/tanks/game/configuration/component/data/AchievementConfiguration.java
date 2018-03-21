package remove.tanks.game.configuration.component.data;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.application.context.configuration.ConfigurationOption;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.data.profile.achievement.*;
import remove.tanks.game.graphics.sprite.SpriteFactory;
import remove.tanks.game.graphics.sprite.SpritePrefabXmlReader;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class AchievementConfiguration {
    @ComponentName("AchievementPrefabXmlReader")
    public static final class AchievementPrefabXmlReaderSupplier extends ComponentSupplier<AchievementPrefabXmlReader> {
        @Override
        public AchievementPrefabXmlReader supplyComponent() {
            return new AchievementPrefabXmlReader(
                    getContext().getComponent("AchievementTypeXmlReader", AchievementTypeXmlReader.class),
                    getContext().getComponent("SpritePrefabXmlReader", SpritePrefabXmlReader.class)
            );
        }
    }

    @ComponentName("AchievementFactory")
    public static final class AchievementFactorySupplier extends ComponentSupplier<AchievementFactory> {
        @Override
        public AchievementFactory supplyComponent() {
            return new AchievementFactory(
                    getContext().getComponent("SpriteFactory", SpriteFactory.class)
            );
        }
    }

    @ComponentName("AchievementAvailabilityChecker")
    public static final class AchievementAvailabilityCheckerSupplier extends ComponentSupplier<AchievementAvailabilityChecker> {
        @Override
        public AchievementAvailabilityChecker supplyComponent() {
            return new AchievementAvailabilityChecker();
        }
    }

    @ComponentName("AchievementPrefabRepository")
    public static final class AchievementPrefabRepositorySupplier extends ComponentSupplier<AchievementPrefabRepository> {
        @Override
        public AchievementPrefabRepository supplyComponent() {
            return getContext().getComponent("AchievementPrefabRepositoryXmlReader", AchievementPrefabRepositoryXmlReader.class)
                    .readAchievementPrefabRepository(
                            Gdx.files.internal(getContext().getConfiguration().getOption(
                                    ConfigurationOption.GameAchievementPrefabRepositoryFilename.getName()))
                    );
        }
    }

    @ComponentName("AchievementPrefabRepositoryXmlReader")
    public static final class AchievementPrefabRepositoryXmlReaderSupplier extends ComponentSupplier<AchievementPrefabRepositoryXmlReader> {
        @Override
        public AchievementPrefabRepositoryXmlReader supplyComponent() {
            return new AchievementPrefabRepositoryXmlReader(
                    getContext().getComponent("XmlReader", XmlReader.class),
                    getContext().getComponent("AchievementPrefabXmlReader", AchievementPrefabXmlReader.class)
            );
        }
    }

    @ComponentName("AchievementStorage")
    public static final class AchievementStorageSupplier extends ComponentSupplier<AchievementStorage> {
        @Override
        public AchievementStorage supplyComponent() {
            return getContext().getComponent("AchievementStorageFactory", AchievementStorageFactory.class)
                    .createAchievementStorage(
                            getContext().getComponent("AchievementPrefabRepository", AchievementPrefabRepository.class),
                            getContext().getComponent("MainAssetStorage", AssetStorage.class),
                            getContext().getComponent("UIScale", Scale.class)
                    );
        }
    }

    @ComponentName("AchievementStorageFactory")
    public static final class AchievementStorageFactorySupplier extends ComponentSupplier<AchievementStorageFactory> {
        @Override
        public AchievementStorageFactory supplyComponent() {
            return new AchievementStorageFactory(
                    getContext().getComponent("AchievementFactory", AchievementFactory.class)
            );
        }
    }

    @ComponentName("AchievementTypeXmlReader")
    public static final class AchievementTypeXmlReaderSupplier extends ComponentSupplier<AchievementTypeXmlReader> {
        @Override
        public AchievementTypeXmlReader supplyComponent() {
            return new AchievementTypeXmlReader();
        }
    }

    @ComponentName("AchievementTypeXmlWriter")
    public static final class AchievementTypeXmlWriterSupplier extends ComponentSupplier<AchievementTypeXmlWriter> {
        @Override
        public AchievementTypeXmlWriter supplyComponent() {
            return new AchievementTypeXmlWriter();
        }
    }
}
