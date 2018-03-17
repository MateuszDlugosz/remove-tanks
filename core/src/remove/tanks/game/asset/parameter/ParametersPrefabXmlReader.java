package remove.tanks.game.asset.parameter;

import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
@SuppressWarnings("unchecked")
public final class ParametersPrefabXmlReader {
    public static final String PARAMETERS_ELEMENT = "parameters";
    public static final String PARAMETER_ELEMENT = "parameter";

    private static final String CLASS_NAME_ATTRIBUTE = "className";
    private static final String NAME_ATTRIBUTE = "name";

    public ParametersPrefab readParametersPrefab(XmlReader.Element element) {
        try {
            return new ParametersPrefab(
                    readAssetLoaderParametersClass(element),
                    readParameters(element.getChildrenByName(PARAMETER_ELEMENT))
            );
        } catch (Exception e) {
            throw new ParametersPrefabXmlReadException(element, e);
        }
    }

    private Class<? extends AssetLoaderParameters> readAssetLoaderParametersClass(XmlReader.Element element) {
        try {
            return (Class<? extends AssetLoaderParameters>) Class.forName(element.getAttribute(CLASS_NAME_ATTRIBUTE).trim());
        } catch (Exception e) {
            throw new ParametersPrefabXmlReadException(element, e);
        }
    }

    private Map<String, String> readParameters(Array<XmlReader.Element> elements) {
        return Arrays.stream(elements.toArray()).collect(Collectors.toMap(
                e -> e.getAttribute(NAME_ATTRIBUTE),
                e -> e.getText().trim()
        ));
    }
}
