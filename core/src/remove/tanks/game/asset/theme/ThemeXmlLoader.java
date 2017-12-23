package remove.tanks.game.asset.theme;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.asset.AssetPrototype;
import remove.tanks.game.asset.AssetPrototypeXmlLoader;

import java.util.List;

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
                    loadAssetPrototypes(filename)
            );
        } catch (Exception e) {
            throw new ThemeXmlLoadException(e);
        }
    }

    private List<AssetPrototype> loadAssetPrototypes(String filename) {
        return assetPrototypeXmlLoader.loadAssetPrototypes(
                xmlReader.parse(loadFile(filename))
                        .getChildByName(AssetPrototypeXmlLoader.ASSETS_ELEMENT));
    }

    private FileHandle loadFile(String filename) {
        return Gdx.files.internal(filename);
    }
}
