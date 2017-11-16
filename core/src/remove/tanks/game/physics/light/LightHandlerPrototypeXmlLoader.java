package remove.tanks.game.physics.light;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class LightHandlerPrototypeXmlLoader {
    public static final String LIGHT_HANDLER_ELEMENT = "lightHandler";
    public static final String LIGHT_HANDLERS_ELEMENT = "lightHandlers";

    private static final String ID_ATTRIBUTE = "id";

    private final LightPrototypeXmlLoader lightPrototypeXmlLoader;

    public LightHandlerPrototypeXmlLoader(LightPrototypeXmlLoader lightPrototypeXmlLoader) {
        this.lightPrototypeXmlLoader = lightPrototypeXmlLoader;
    }

    public List<LightHandlerPrototype> loadLightHandlerPrototypes(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(LIGHT_HANDLER_ELEMENT).toArray())
                .map(this::loadLightHandlerPrototype)
                .collect(Collectors.toList());
    }

    public LightHandlerPrototype loadLightHandlerPrototype(XmlReader.Element element) {
        try {
            return new LightHandlerPrototype(
                    loadId(element),
                    loadLightPrototype(element)
            );
        } catch (Exception e) {
            throw new LightHandlerPrototypeXmlLoadException(element, e);
        }
    }

    private String loadId(XmlReader.Element element) {
        return element.getAttribute(ID_ATTRIBUTE).trim();
    }

    private LightPrototype loadLightPrototype(XmlReader.Element element) {
        return lightPrototypeXmlLoader.loadLightPrototype(
                element.getChildByName(LightPrototypeXmlLoader.LIGHT_ELEMENT)
        );
    }
}
