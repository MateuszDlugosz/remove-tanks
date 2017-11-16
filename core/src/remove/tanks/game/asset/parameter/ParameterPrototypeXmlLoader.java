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
public final class ParameterPrototypeXmlLoader {
    public static final String PARAMETERS_ELEMENT = "parameters";
    public static final String PARAMETER_ELEMENT = "parameter";

    private static final String CLASS_NAME_ATTRIBUTE = "className";
    private static final String NAME_ATTRIBUTE = "name";

    public ParameterPrototype loadParametersPrototype(XmlReader.Element element) {
        return new ParameterPrototype(
                loadAssetLoaderParametersClass(element),
                loadParameters(element.getChildrenByName(PARAMETER_ELEMENT))
        );
    }

    private Class<? extends AssetLoaderParameters> loadAssetLoaderParametersClass(XmlReader.Element element) {
        try {
            return (Class<? extends AssetLoaderParameters>) Class.forName(element.getAttribute(CLASS_NAME_ATTRIBUTE).trim());
        } catch (ClassNotFoundException e) {
            throw new ParameterClassNotFoundException(e);
        }
    }

    private Map<String, String> loadParameters(Array<XmlReader.Element> elements) {
        return Arrays.stream(elements.toArray()).collect(Collectors.toMap(
                e -> e.getAttribute(NAME_ATTRIBUTE),
                e -> e.getText().trim()
        ));
    }
}
