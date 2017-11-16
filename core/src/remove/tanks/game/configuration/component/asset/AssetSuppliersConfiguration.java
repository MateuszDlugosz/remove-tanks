package remove.tanks.game.configuration.component.asset;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.asset.AssetPrototype;
import remove.tanks.game.asset.AssetPrototypeXmlLoader;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.asset.AssetStorageFactory;
import remove.tanks.game.asset.parameter.ParameterFactory;
import remove.tanks.game.asset.parameter.ParameterPrototypeXmlLoader;
import remove.tanks.game.asset.parameter.ParticleEffectParameterFactory;
import remove.tanks.game.asset.parameter.RegistrableParameterFactory;
import remove.tanks.game.asset.theme.ThemeXmlLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class AssetSuppliersConfiguration {
    @ComponentName("ParameterPrototypeXmlLoader")
    public static final class ParameterPrototypeXmlLoaderSupplier extends ComponentSupplier<ParameterPrototypeXmlLoader> {
        @Override
        public ParameterPrototypeXmlLoader supplyComponent() {
            return new ParameterPrototypeXmlLoader();
        }
    }

    @ComponentName("AssetPrototypeXmlLoader")
    public static final class AssetPrototypeXmlLoaderSupplier extends ComponentSupplier<AssetPrototypeXmlLoader> {
        @Override
        public AssetPrototypeXmlLoader supplyComponent() {
            return new AssetPrototypeXmlLoader(
                    getContext().getComponent("ParameterPrototypeXmlLoader", ParameterPrototypeXmlLoader.class)
            );
        }
    }

    @ComponentName("AssetLoaderParameterFactory")
    public static final class ParameterFactorySupplier extends ComponentSupplier<ParameterFactory> {
        @Override
        public ParameterFactory supplyComponent() {
            return new ParameterFactory(
                    new RegistrableParameterFactory[] {
                            new ParticleEffectParameterFactory()
                    }
            );
        }
    }

    @ComponentName("AssetStorageFactory")
    public static final class AssetStorageFactorySupplier extends ComponentSupplier<AssetStorageFactory> {
        @Override
        public AssetStorageFactory supplyComponent() {
            return new AssetStorageFactory(
                    getContext().getComponent("AssetLoaderParameterFactory", ParameterFactory.class)
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
}
