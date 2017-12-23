package remove.tanks.game.asset;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.asset.parameter.ParameterPrototype;
import remove.tanks.game.asset.parameter.ParameterPrototypeXmlLoader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class AssetPrototypeXmlLoader {
    public static final String ASSET_ELEMENT = "asset";
    public static final String ASSETS_ELEMENT = "assets";

    private static final String ID_ATTRIBUTE = "id";
    private static final String CLASS_NAME_ELEMENT = "className";
    private static final String FILENAME_ELEMENT = "filename";

    private final ParameterPrototypeXmlLoader parameterPrototypeXmlLoader;

    public AssetPrototypeXmlLoader(ParameterPrototypeXmlLoader parameterPrototypeXmlLoader) {
        this.parameterPrototypeXmlLoader = parameterPrototypeXmlLoader;
    }

    public List<AssetPrototype> loadAssetPrototypes(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(ASSET_ELEMENT).toArray())
                .map(this::loadAssetPrototype)
                .collect(Collectors.toList());
    }

    public AssetPrototype loadAssetPrototype(XmlReader.Element element) {
        try {
            return new AssetPrototype(
                    element.getAttribute(ID_ATTRIBUTE).trim(),
                    Class.forName(element.getChildByName(CLASS_NAME_ELEMENT).getText().trim()),
                    element.getChildByName(FILENAME_ELEMENT).getText().trim(),
                    loadParametersPrototype(element
                            .getChildByName(ParameterPrototypeXmlLoader.PARAMETERS_ELEMENT)
                    )
            );
        } catch (Exception e) {
            throw new AssetPrototypeXmlLoadException(element, e);
        }
    }

    private ParameterPrototype loadParametersPrototype(XmlReader.Element element) {
        if (element == null) {
            return null;
        }
        return parameterPrototypeXmlLoader.loadParametersPrototype(element);
    }
}
