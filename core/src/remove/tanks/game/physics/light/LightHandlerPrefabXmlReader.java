package remove.tanks.game.physics.light;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class LightHandlerPrefabXmlReader {
    public static final String LIGHT_HANDLER_ELEMENT = "lightHandler";
    public static final String LIGHT_HANDLERS_ELEMENT = "lightHandlers";

    private static final String ID_ATTRIBUTE = "id";

    private final LightPrefabXmlReader lightPrefabXmlReader;

    public LightHandlerPrefabXmlReader(LightPrefabXmlReader lightPrefabXmlReader) {
        this.lightPrefabXmlReader = lightPrefabXmlReader;
    }

    public List<LightHandlerPrefab> readLightHandlerPrefabs(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(LIGHT_HANDLER_ELEMENT).toArray())
                .map(this::readLightHandlerPrefab)
                .collect(Collectors.toList());
    }

    public LightHandlerPrefab readLightHandlerPrefab(XmlReader.Element element) {
        try {
            return new LightHandlerPrefab(
                    readId(element),
                    readLightPrefab(element)
            );
        } catch (Exception e) {
            throw new LightHandlerPrefabXmlReadException(element, e);
        }
    }

    private String readId(XmlReader.Element element) {
        return element.getAttribute(ID_ATTRIBUTE).trim();
    }

    private LightPrefab readLightPrefab(XmlReader.Element element) {
        return lightPrefabXmlReader.readLightPrefab(
                element.getChildByName(LightPrefabXmlReader.LIGHT_ELEMENT)
        );
    }
}
