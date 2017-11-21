package remove.tanks.game.level.resource.factory;

import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.asset.AssetStorageFactory;
import remove.tanks.game.asset.theme.ThemeXmlLoader;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.resource.AbstractInternalResourceFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class AssetStorageInternalResourceFactory
        extends AbstractInternalResourceFactory<AssetStorage>
{
    public static final String THEME_FILENAME_PROPERTY = "theme.filename";

    private final ThemeXmlLoader themeXmlLoader;
    private final AssetStorageFactory assetStorageFactory;

    public AssetStorageInternalResourceFactory(
            ThemeXmlLoader themeXmlLoader,
            AssetStorageFactory assetStorageFactory
    ) {
        this.themeXmlLoader = themeXmlLoader;
        this.assetStorageFactory = assetStorageFactory;
    }

    @Override
    protected String getResourceName() {
        return LevelResource.AssetStorage.toString();
    }

    @Override
    protected AssetStorage getResourceObject(ResourceRegistry registry) {
        return assetStorageFactory.createAssetStorage(
                themeXmlLoader.loadTheme(registry.getResource(LevelResource.Properties.toString(),
                        Properties.class).getString(THEME_FILENAME_PROPERTY)).getAssetPrototypes()
        );
    }

    @Override
    protected String[] getRequiredResources() {
        return new String[] {
                LevelResource.Properties.toString()
        };
    }
}
