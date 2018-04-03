package remove.tanks.game.configuration.component.level;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.XmlReader;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.application.context.component.Scope;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentScope;
import remove.tanks.game.application.context.configuration.ConfigurationOption;
import remove.tanks.game.data.profile.Profile;
import remove.tanks.game.graphics.camera.Game2DCamera;
import remove.tanks.game.input.InputMapper;
import remove.tanks.game.level.*;
import remove.tanks.game.level.engine.EnginePrefabXmlReader;
import remove.tanks.game.level.engine.entity.EntityTiledMapInitializer;
import remove.tanks.game.level.event.EventExecutor;
import remove.tanks.game.level.preload.PreloadDataXmlReader;
import remove.tanks.game.level.resource.ResourceRegistryFactory;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.level.resource.configuration.ResourceConfigurationsXmlReader;
import remove.tanks.game.locale.Locale;
import remove.tanks.game.utility.number.random.RandomNumberGenerator;
import remove.tanks.game.utility.scale.Scale;

import java.util.EnumMap;

/**
 * @author Mateusz Długosz
 */
public final class LevelConfiguration {
    @ComponentName("LevelFactory")
    @ComponentScope(Scope.Prototype)
    public static final class LevelFactorySupplier extends ComponentSupplier<LevelFactory> {
        @Override
        public LevelFactory supplyComponent() {
            EnumMap<ResourceType, Object> globalObjects = new EnumMap<>(ResourceType.class);
            globalObjects.put(ResourceType.GameCameraResource,
                    getContext().getComponent("GameCamera", Game2DCamera.class));
            globalObjects.put(ResourceType.SpriteBatchResource,
                    getContext().getComponent("SpriteBatch", SpriteBatch.class));
            globalObjects.put(ResourceType.UICameraResource,
                    getContext().getComponent("UICamera", Game2DCamera.class));
            globalObjects.put(ResourceType.UIScaleResource,
                    getContext().getComponent("UIScale", Scale.class));
            globalObjects.put(ResourceType.UISkinResource,
                    getContext().getComponent("UISkin", Skin.class));
            globalObjects.put(ResourceType.LocaleResource,
                    getContext().getComponent("Locale", Locale.class));
            globalObjects.put(ResourceType.WorldScaleResource,
                    getContext().getComponent("WorldScale", Scale.class));
            globalObjects.put(ResourceType.InputMapperResource,
                    getContext().getComponent("InputMapper", InputMapper.class));
            globalObjects.put(ResourceType.PlayerProfileResource,
                    getContext().getComponent("Profile", Profile.class));
            globalObjects.put(ResourceType.ExternalEventBusResource,
                    getContext().getComponent("EventBus", EventBus.class));

            return new LevelFactory(
                    globalObjects, getContext().getComponent("ResourceRegistryFactory", ResourceRegistryFactory.class));
        }
    }

    @ComponentName("LevelPrefabXmlReader")
    public static final class LevelPrefabXmlReaderSupplier extends ComponentSupplier<LevelPrefabXmlReader> {
        @Override
        public LevelPrefabXmlReader supplyComponent() {
            return new LevelPrefabXmlReader(
                    getContext().getComponent("XmlReader", XmlReader.class),
                    getContext().getComponent("PreloadDataXmlReader", PreloadDataXmlReader.class),
                    getContext().getComponent("ResourceConfigurationsXmlReader", ResourceConfigurationsXmlReader.class),
                    getContext().getComponent("EnginePrefabXmlReader", EnginePrefabXmlReader.class)
            );
        }
    }

    @ComponentName("LevelControllerFactory")
    public static final class LevelControllerFactorySupplier extends ComponentSupplier<LevelControllerFactory> {
        @Override
        public LevelControllerFactory supplyComponent() {
            return new LevelControllerFactory(
                    getContext().getComponent("LevelUpdater", LevelUpdater.class),
                    getContext().getComponent("EventExecutor", EventExecutor.class),
                    getContext().getComponent("LevelInitializer", LevelInitializer.class)
            );
        }
    }

    @ComponentName("LevelUpdater")
    public static final class LevelUpdaterSupplier extends ComponentSupplier<LevelUpdater> {
        @Override
        public LevelUpdater supplyComponent() {
            return new LevelUpdater();
        }
    }

    @ComponentName("LevelInitializer")
    public static final class LevelInitializerSupplier extends ComponentSupplier<LevelInitializer> {
        @Override
        public LevelInitializer supplyComponent() {
            return new LevelInitializer(
                    getContext().getComponent("EntityTiledMapInitializer", EntityTiledMapInitializer.class)
            );
        }
    }

    @ComponentName("LevelSequenceXmlReader")
    public static final class LevelSequenceXmlReaderSupplier extends ComponentSupplier<LevelSequenceXmlReader> {
        @Override
        public LevelSequenceXmlReader supplyComponent() {
            return new LevelSequenceXmlReader();
        }
    }

    @ComponentName("LevelPresenter")
    public static final class LevelPresenterSupplier extends ComponentSupplier<LevelPresenter> {
        @Override
        public LevelPresenter supplyComponent() {
                return getContext().getComponent("LevelPresenterFactory", LevelPresenterFactory.class)
                        .createLevelPresenter(
                                getContext().getComponent("LevelPresenterPrefabXmlReader",
                                        LevelPresenterPrefabXmlReader.class)
                                        .readLevelPresenterPrefab(
                                                getContext().getConfiguration().getOption(
                                                        ConfigurationOption.GameLevelPresenterPrefabFilename.getName())
                                        )
                        );
        }
    }

    @ComponentName("LevelPresenterPrefabXmlReader")
    public static final class LevelPresenterPrefabXmlReaderSupplier extends ComponentSupplier<LevelPresenterPrefabXmlReader> {
        @Override
        public LevelPresenterPrefabXmlReader supplyComponent() {
            return new LevelPresenterPrefabXmlReader(
                    getContext().getComponent("XmlReader", XmlReader.class),
                    getContext().getComponent("LevelSequenceXmlReader", LevelSequenceXmlReader.class),
                    getContext().getComponent("LevelPrefabXmlReader", LevelPrefabXmlReader.class)
            );
        }
    }

    @ComponentName("LevelPresenterFactory")
    public static final class LevelPresenterFactorySupplier extends ComponentSupplier<LevelPresenterFactory> {
        @Override
        public LevelPresenterFactory supplyComponent() {
            return new LevelPresenterFactory(
                    getContext().getComponent("RandomNumberGenerator", RandomNumberGenerator.class),
                    getContext().getComponent("LevelFactory", LevelFactory.class),
                    getContext().getComponent("LevelControllerFactory", LevelControllerFactory.class)
            );
        }
    }

    @ComponentName("LevelDisposer")
    public static final class LevelDisposerSupplier extends ComponentSupplier<LevelDisposer> {
        @Override
        public LevelDisposer supplyComponent() {
            return new LevelDisposer();
        }
    }

    @ComponentName("LevelTransferablePropertiesExtractor")
    public static final class LevelTransferablePropertiesExtractorSupplier extends ComponentSupplier<LevelTransferablePropertiesExtractor> {
        @Override
        public LevelTransferablePropertiesExtractor supplyComponent() {
            return new LevelTransferablePropertiesExtractor();
        }
    }
}
