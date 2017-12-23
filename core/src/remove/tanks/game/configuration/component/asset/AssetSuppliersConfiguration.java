package remove.tanks.game.configuration.component.asset;

import com.badlogic.gdx.assets.loaders.AssetLoader;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.asset.*;
import remove.tanks.game.asset.parameter.ParametersFactory;
import remove.tanks.game.asset.parameter.ParametersPrototypeXmlLoader;
import remove.tanks.game.asset.parameter.ParticleEffectParametersFactory;
import remove.tanks.game.asset.theme.ThemeXmlLoader;
import remove.tanks.game.graphic.effect.Effect;
import remove.tanks.game.graphic.effect.EffectAssetLoader;
import remove.tanks.game.graphic.effect.EffectFactory;
import remove.tanks.game.graphic.effect.EffectPrototypeXmlLoader;
import remove.tanks.game.graphic.particle.ParticleFile;
import remove.tanks.game.graphic.particle.ParticleFileAssetLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class AssetSuppliersConfiguration {
    @ComponentName("ParametersPrototypeXmlLoader")
    public static final class ParameterPrototypeXmlLoaderSupplier extends ComponentSupplier<ParametersPrototypeXmlLoader> {
        @Override
        public ParametersPrototypeXmlLoader supplyComponent() {
            return new ParametersPrototypeXmlLoader();
        }
    }

    @ComponentName("AssetPrototypeXmlLoader")
    public static final class AssetPrototypeXmlLoaderSupplier extends ComponentSupplier<AssetPrototypeXmlLoader> {
        @Override
        public AssetPrototypeXmlLoader supplyComponent() {
            return new AssetPrototypeXmlLoader(
                    getContext().getComponent("ParametersPrototypeXmlLoader", ParametersPrototypeXmlLoader.class)
            );
        }
    }

    @ComponentName("AssetLoaderParameterFactory")
    public static final class ParameterFactorySupplier extends ComponentSupplier<ParametersFactory> {
        @Override
        public ParametersFactory supplyComponent() {
            ParametersFactory parametersFactory = new ParametersFactory();
            parametersFactory.registerFactory(new ParticleEffectParametersFactory());
            return parametersFactory;
        }
    }

    @ComponentName("AssetStorageFactory")
    public static final class AssetStorageFactorySupplier extends ComponentSupplier<AssetStorageFactory> {
        @Override
        public AssetStorageFactory supplyComponent() {
            return new AssetStorageFactory(
                    getContext().getComponent("AssetLoaderParameterFactory", ParametersFactory.class),
                    getContext().getComponent("AssetManagerFactory", AssetManagerFactory.class)
            );
        }
    }

    @ComponentName("MainAssetStorage")
    public static final class MainAssetStorageSupplier extends ComponentSupplier<AssetStorage> {
        @Override
        public AssetStorage supplyComponent() {
            List<AssetPrototype> prototypes = new ArrayList<>();
            prototypes.add(new AssetPrototype(
                    "button-select", Sound.class, "audio/sounds/button-select-0.ogg", null
            ));
            prototypes.add(new AssetPrototype(
                    "button-change", Sound.class, "audio/sounds/button-change-0.ogg", null
            ));

            return getContext()
                    .getComponent("AssetStorageFactory", AssetStorageFactory.class)
                    .createAssetStorage(prototypes);
        }
    }

    @ComponentName("ThemeXmlLoader")
    public static final class ThemeXmlLoaderSupplier extends ComponentSupplier<ThemeXmlLoader> {
        @Override
        public ThemeXmlLoader supplyComponent() {
            return new ThemeXmlLoader(
                    getContext().getComponent("XmlReader", XmlReader.class),
                    getContext().getComponent("AssetPrototypeXmlLoader", AssetPrototypeXmlLoader.class)
            );
        }
    }

    @ComponentName("AssetManagerFactory")
    public static final class AssetManagerFactorySupplier extends ComponentSupplier<AssetManagerFactory> {
        @Override
        public AssetManagerFactory supplyComponent() {
            Map<Class<?>, AssetLoader> assetLoaders = new HashMap<>();
            assetLoaders.put(
                    Effect.class,
                    new EffectAssetLoader(
                            new InternalFileHandleResolver(),
                            getContext().getComponent("EffectPrototypeXmlLoader", EffectPrototypeXmlLoader.class),
                            getContext().getComponent("EffectFactory", EffectFactory.class)
                    )
            );
            assetLoaders.put(
                    ParticleFile.class,
                    new ParticleFileAssetLoader(
                            new InternalFileHandleResolver()
                    )
            );
            return new AssetManagerFactory(assetLoaders);
        }
    }
}
