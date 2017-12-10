package remove.tanks.game.asset.theme;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.asset.AssetPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class ThemeXmlLoader {
    private final XmlReader xmlReader;
    private final AssetPrototypeXmlLoader assetPrototypeXmlLoader;

    public ThemeXmlLoader(XmlReader xmlReader, AssetPrototypeXmlLoader assetPrototypeXmlLoader) {
        this.xmlReader = xmlReader;
        this.assetPrototypeXmlLoader = assetPrototypeXmlLoader;
    }

    public Theme loadTheme(String filename) {
        try {
            return new Theme(
                    assetPrototypeXmlLoader.loadAssetPrototypes(
                            xmlReader.parse(Gdx.files.internal(filename))
                                    .getChildByName(AssetPrototypeXmlLoader.ASSETS_ELEMENT))
            );
        } catch (Exception e) {
            throw new ThemeXmlLoadException(e);
        }
    }
}
