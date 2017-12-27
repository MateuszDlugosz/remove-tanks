package remove.tanks.game.configuration.level;

import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.asset.AssetStorageFactory;
import remove.tanks.game.asset.theme.ThemeXmlLoader;
import remove.tanks.game.level.LevelPropertiesInitializer;
import remove.tanks.game.level.constant.LevelProperty;
import remove.tanks.game.level.engine.EngineFactory;
import remove.tanks.game.level.engine.entity.EntityPrototypeRepositoryXmlLoader;
import remove.tanks.game.level.resource.AbstractExternalResourceFactory;
import remove.tanks.game.level.resource.AbstractInternalResourceFactory;
import remove.tanks.game.level.resource.ResourceRegistryFactory;
import remove.tanks.game.level.resource.factory.*;
import remove.tanks.game.physics.light.world.WorldLightFactory;
import remove.tanks.game.physics.world.WorldFactory;
import remove.tanks.game.utility.properties.MapPropertiesConverter;
import remove.tanks.game.utility.properties.PropertyExistsValidator;

/**
 * @author Mateusz Długosz
 */
public final class ResourceSupplierConfiguration {
    @ComponentName("ResourceRegistryFactory")
    public static final class ResourceRegistryFactorySupplier extends ComponentSupplier<ResourceRegistryFactory> {
        @Override
        public ResourceRegistryFactory supplyComponent() {
            return new ResourceRegistryFactory(
                    new AbstractExternalResourceFactory[] {
                            new LevelPrototypeExternalResourceFactory(),
                            new UiSkinExternalResourceFactory(),
                            new GameCameraExternalResourceFactory(),
                            new HudCameraExternalResourceFactory(),
                            new SpriteBatchExternalResourceFactory(),
                            new ConfigurationExternalResourceFactory(),
                            new LocaleExternalResourceFactory(),
                            new WorldScaleExternalResourceFactory(),
                            new UiScaleExternalResourceFactory()
                    },
                    new AbstractInternalResourceFactory[] {
                            new PropertiesInternalResourceFactory(
                                    new PropertyExistsValidator(
                                            new String[] {
                                                    LevelProperty.LevelResourceThemeFilename.getName(),
                                                    LevelProperty.LevelResourceTiledMapFilename.getName(),
                                                    LevelProperty.LevelResourceEntityPrototypeRepositoryFilename.getName()
                                            }
                                    ),
                                    getContext().getComponent("LevelPropertiesInitializer", LevelPropertiesInitializer.class)
                            ),
                            new EventBusInternalResourceFactory(),
                            new InputMapperInternalResourceFactory(),
                            new AssetStorageInternalResourceFactory(
                                    getContext().getComponent("ThemeXmlLoader", ThemeXmlLoader.class),
                                    getContext().getComponent("AssetStorageFactory", AssetStorageFactory.class)
                            ),
                            new TiledMapInternalResourceFactory(
                                    getContext().getComponent("TmxMapLoader", TmxMapLoader.class)
                            ),
                            new TiledMapBoundariesInternalResourceFactory(
                                    getContext().getComponent("MapPropertiesConverter", MapPropertiesConverter.class)
                            ),
                            new EntityPrototypeRepositoryInternalResourceFactory(
                                    getContext().getComponent("EntityPrototypeRepositoryXmlLoader", EntityPrototypeRepositoryXmlLoader.class)
                            ),
                            new WorldInternalResourceFactory(
                                    getContext().getComponent("WorldFactory", WorldFactory.class)
                            ),
                            new WorldLightInternalResourceFactory(
                                    getContext().getComponent("WorldLightFactory", WorldLightFactory.class)
                            ),
                            new EngineInternalResourceFactory(
                                    getContext().getComponent("EngineFactory", EngineFactory.class)
                            )
                    }
            );
        }
    }
}
