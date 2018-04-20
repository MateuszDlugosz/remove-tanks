package remove.tanks.game.configuration.component.level;

import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.asset.AssetPrefabRepositoryXmlReader;
import remove.tanks.game.asset.AssetStorageFactory;
import remove.tanks.game.level.engine.EngineFactory;
import remove.tanks.game.level.engine.entity.EntityFactory;
import remove.tanks.game.level.engine.entity.EntityPrefabRepositoryXmlReader;
import remove.tanks.game.level.engine.entity.EntityPrefabStorageFactory;
import remove.tanks.game.level.resource.AbstractResourceFactory;
import remove.tanks.game.level.resource.ResourceRegistryFactory;
import remove.tanks.game.level.resource.configuration.ResourceConfigurationsXmlReader;
import remove.tanks.game.level.resource.factories.*;
import remove.tanks.game.physics.light.world.WorldLightFactory;
import remove.tanks.game.physics.light.world.WorldLightPropertyTranslator;
import remove.tanks.game.physics.world.WorldFactory;
import remove.tanks.game.physics.world.WorldPropertyTranslator;
import remove.tanks.game.utility.properties.MapPropertiesConverter;
import remove.tanks.game.utility.properties.PropertiesXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class ResourceConfiguration {
    @ComponentName("ResourceRegistryFactory")
    public static final class ResourceRegistryFactorySupplier extends ComponentSupplier<ResourceRegistryFactory> {
        @Override
        public ResourceRegistryFactory supplyComponent() {
            return new ResourceRegistryFactory(
                    new AbstractResourceFactory[] {
                            new WorldScaleGlobalResourceFactory(),
                            new WorldLightLocalResourceFactory(
                                    getContext().getComponent("WorldLightFactory", WorldLightFactory.class),
                                    getContext().getComponent("WorldLightPropertyTranslator", WorldLightPropertyTranslator.class)
                            ),
                            new WorldLocalResourceFactory(
                                    getContext().getComponent("WorldFactory", WorldFactory.class),
                                    getContext().getComponent("WorldPropertyTranslator", WorldPropertyTranslator.class)
                            ),
                            new AssetStorageLocalResourceFactory(
                                    getContext().getComponent("AssetPrefabRepositoryXmlReader", AssetPrefabRepositoryXmlReader.class),
                                    getContext().getComponent("AssetStorageFactory", AssetStorageFactory.class)
                            ),
                            new GameCameraGlobalResourceFactory(),
                            new UICameraGlobalResourceFactory(),
                            new SpriteBatchGlobalResourceFactory(),
                            new LocaleGlobalResourceFactory(),
                            new UISkinGlobalResourceFactory(),
                            new UIScaleGlobalResourceFactory(),
                            new InputMapperGlobalResourceFactory(),
                            new EntityPrefabStorageLocalResourceFactory(
                                    getContext().getComponent("EntityPrefabRepositoryXmlReader", EntityPrefabRepositoryXmlReader.class),
                                    getContext().getComponent("EntityPrefabStorageFactory", EntityPrefabStorageFactory.class)
                            ),
                            new PlayerProfileGlobalResourceFactory(),
                            new EventBusLocalResourceFactory(),
                            new TiledMapLocalResourceFactory(
                                    getContext().getComponent("TmxMapLoader", TmxMapLoader.class)
                            ),
                            new TiledMapBoundaryLocalResourceFactory(
                                    getContext().getComponent("MapPropertiesConverter", MapPropertiesConverter.class)
                            ),
                            new EngineLocalResourceFactory(
                                    getContext().getComponent("EngineFactory", EngineFactory.class)
                            ),
                            new LevelPrefabTemporaryResourceFactory(),
                            new EntityControllerLocalResourceFactory(
                                    getContext().getComponent("EntityFactory", EntityFactory.class)
                            ),
                            new ExternalEventBusGlobalResourceFactory(),
                            new TiledMapRendererLocalResourceFactory(),
                            new LevelPropertiesLocalResourceFactory()
                    }
            );
        }
    }

    @ComponentName("ResourceConfigurationsXmlReader")
    public static final class ResourceConfigurationsXmlReaderSupplier extends ComponentSupplier<ResourceConfigurationsXmlReader> {
        @Override
        public ResourceConfigurationsXmlReader supplyComponent() {
            return new ResourceConfigurationsXmlReader(
                    getContext().getComponent("PropertiesXmlReader", PropertiesXmlReader.class)
            );
        }
    }
}
