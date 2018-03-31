package remove.tanks.game.configuration.component.asset;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.AssetLoader;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.application.context.configuration.ConfigurationOption;
import remove.tanks.game.asset.*;
import remove.tanks.game.asset.parameter.ParametersFactory;
import remove.tanks.game.asset.parameter.ParametersPrefabXmlReader;
import remove.tanks.game.asset.parameter.ParticleEffectParametersFactory;
import remove.tanks.game.asset.parameter.SubParametersFactory;
import remove.tanks.game.graphics.particle.ParticleFile;
import remove.tanks.game.graphics.particle.ParticleFileAssetLoader;
import remove.tanks.game.graphics.particle.ParticleImagesDirectory;
import remove.tanks.game.graphics.particle.ParticleImagesDirectoryAssetLoader;
import remove.tanks.game.graphics.shader.FragmentShaderFile;
import remove.tanks.game.graphics.shader.FragmentShaderFileAssetLoader;
import remove.tanks.game.graphics.shader.VertexShaderFile;
import remove.tanks.game.graphics.shader.VertexShaderFileAssetLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class AssetConfiguration {
    @ComponentName("MainAssetStorage")
    public static final class MainAssetStorageSupplier extends ComponentSupplier<AssetStorage> {
        @Override
        public AssetStorage supplyComponent() {
            AssetStorage assetStorage = getContext().getComponent("AssetStorageFactory", AssetStorageFactory.class)
                    .createAssetStorage(
                            getContext().getComponent("AssetPrefabRepositoryXmlReader", AssetPrefabRepositoryXmlReader.class)
                                    .readAssetPrefabRepository(
                                            Gdx.files.internal(getContext().getConfiguration()
                                                    .getOption(ConfigurationOption.GameMainAssetPrefabRepositoryFilename.getName()))
                                    )
                    );
            assetStorage.loadAsset("UIButtonChange0Sound");
            assetStorage.loadAsset("UIButtonSelect0Sound");
            assetStorage.loadAsset("Tester0Sound");
            assetStorage.loadAsset("Tester0Music");
            assetStorage.loadAsset("AchievementAtlas");
            assetStorage.loadAsset("CampaignAtlas");

            return assetStorage;
        }
    }

    @ComponentName("AssetPrefabRepositoryXmlReader")
    public static final class AssetPrefabRepositoryXmlReaderSupplier extends ComponentSupplier<AssetPrefabRepositoryXmlReader> {
        @Override
        public AssetPrefabRepositoryXmlReader supplyComponent() {
            return new AssetPrefabRepositoryXmlReader(
                    getContext().getComponent("XmlReader", XmlReader.class),
                    getContext().getComponent("AssetPrefabXmlReader", AssetPrefabXmlReader.class)
            );
        }
    }

    @ComponentName("AssetPrefabXmlReader")
    public static final class AssetPrefabXmlReaderSupplier extends ComponentSupplier<AssetPrefabXmlReader> {
        @Override
        public AssetPrefabXmlReader supplyComponent() {
            return new AssetPrefabXmlReader(
                    getContext().getComponent("ParametersPrefabXmlReader", ParametersPrefabXmlReader.class)
            );
        }
    }

    @ComponentName("AssetManagerFactory")
    public static final class AssetManagerFactorySupplier extends ComponentSupplier<AssetManagerFactory> {
        @Override
        public AssetManagerFactory supplyComponent() {
            Map<Class<?>, AssetLoader> assetLoaders = new HashMap<>();
            assetLoaders.put(ParticleFile.class,
                    new ParticleFileAssetLoader(new InternalFileHandleResolver()));
            assetLoaders.put(ParticleImagesDirectory.class,
                    new ParticleImagesDirectoryAssetLoader(new InternalFileHandleResolver()));
            assetLoaders.put(FragmentShaderFile.class,
                    new FragmentShaderFileAssetLoader(new InternalFileHandleResolver()));
            assetLoaders.put(VertexShaderFile.class,
                    new VertexShaderFileAssetLoader(new InternalFileHandleResolver()));

            return new AssetManagerFactory(assetLoaders);
        }
    }

    @ComponentName("AssetStorageFactory")
    public static final class AssetStorageFactorySupplier extends ComponentSupplier<AssetStorageFactory> {
        @Override
        public AssetStorageFactory supplyComponent() {
            return new AssetStorageFactory(
                    getContext().getComponent("AssetManagerFactory", AssetManagerFactory.class),
                    getContext().getComponent("ParametersFactory", ParametersFactory.class)
            );
        }
    }

    @ComponentName("ParametersPrefabXmlReader")
    public static final class ParametersPrefabXmlReaderSupplier extends ComponentSupplier<ParametersPrefabXmlReader> {
        @Override
        public ParametersPrefabXmlReader supplyComponent() {
            return new ParametersPrefabXmlReader();
        }
    }

    @ComponentName("ParametersFactory")
    public static final class ParametersFactorySupplier extends ComponentSupplier<ParametersFactory> {
        @Override
        public ParametersFactory supplyComponent() {
            return new ParametersFactory(
                    new SubParametersFactory[] {
                            new ParticleEffectParametersFactory()
                    }
            );
        }
    }

    @ComponentName("AssetIdXmlReader")
    public static final class AssetIdXmlReaderSupplier extends ComponentSupplier<AssetIdXmlReader> {
        @Override
        public AssetIdXmlReader supplyComponent() {
            return new AssetIdXmlReader();
        }
    }
}
