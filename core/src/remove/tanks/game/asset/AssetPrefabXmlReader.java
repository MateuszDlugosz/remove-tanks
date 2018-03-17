package remove.tanks.game.asset;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.asset.parameter.ParametersPrefab;
import remove.tanks.game.asset.parameter.ParametersPrefabXmlReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class AssetPrefabXmlReader {
    public static final String ASSET_ELEMENT = "asset";
    public static final String ASSETS_ELEMENT = "assets";

    private static final String ASSET_CLASS_ELEMENT = "assetClass";
    private static final String FILENAME_ELEMENT = "filename";
    private static final String ID_ATTRIBUTE = "id";

    private final ParametersPrefabXmlReader parametersPrefabXmlReader;

    public AssetPrefabXmlReader(ParametersPrefabXmlReader parametersPrefabXmlReader) {
        this.parametersPrefabXmlReader = parametersPrefabXmlReader;
    }

    public List<AssetPrefab> readAssetPrefabs(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(ASSET_ELEMENT).toArray())
                .map(this::readAssetPrefab)
                .collect(Collectors.toList());
    }

    public AssetPrefab readAssetPrefab(XmlReader.Element element) {
        try {
            return new AssetPrefab(
                    readId(element),
                    readFilename(element),
                    readAssetClass(element),
                    readParametersPrefab(element)
            );
        } catch (Exception e) {
            throw new AssetPrefabXmlReadException(element, e);
        }
    }

    private String readId(XmlReader.Element element) {
        return element.getAttribute(ID_ATTRIBUTE).trim();
    }

    private String readFilename(XmlReader.Element element) {
        return element.getChildByName(FILENAME_ELEMENT).getText().trim();
    }

    private Class<?> readAssetClass(XmlReader.Element element) throws ClassNotFoundException {
        return Class.forName(element.getChildByName(ASSET_CLASS_ELEMENT).getText().trim());
    }

    private ParametersPrefab readParametersPrefab(XmlReader.Element element) {
        if (element.getChildByName(ParametersPrefabXmlReader.PARAMETERS_ELEMENT) == null) {
            return null;
        }
        return parametersPrefabXmlReader.readParametersPrefab(
                element.getChildByName(ParametersPrefabXmlReader.PARAMETERS_ELEMENT));
    }
}
