package remove.tanks.game.physics.light;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.graphics.color.ColorPrefab;
import remove.tanks.game.graphics.color.ColorPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class DirectionalLightPrefabXmlReader implements SubLightPrefabXmlReader<DirectionalLightPrefab> {
    private static final String DIRECTION_DEGREE_ELEMENT = "directionDegree";
    private static final String X_RAY_ELEMENT = "xRay";

    private final ColorPrefabXmlReader colorPrefabXmlReader;

    public DirectionalLightPrefabXmlReader(ColorPrefabXmlReader colorPrefabXmlReader) {
        this.colorPrefabXmlReader = colorPrefabXmlReader;
    }

    @Override
    public DirectionalLightPrefab readLightPrefab(XmlReader.Element element) {
        try {
            return new DirectionalLightPrefab(
                    readColorPrefab(element),
                    readDirectionDegree(element),
                    readXRay(element)
            );
        } catch (Exception e) {
            throw new LightPrefabXmlReadException(element, e);
        }
    }

    private ColorPrefab readColorPrefab(XmlReader.Element element) {
        return colorPrefabXmlReader.readColorPrefab(
                element.getChildByName(ColorPrefabXmlReader.COLOR_ELEMENT)
        );
    }

    private float readDirectionDegree(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(DIRECTION_DEGREE_ELEMENT).getText().trim());
    }

    private boolean readXRay(XmlReader.Element element) {
        return Boolean.valueOf(element.getChildByName(X_RAY_ELEMENT).getText().trim());
    }

    @Override
    public LightType getReaderType() {
        return LightType.DirectionalLight;
    }
}
