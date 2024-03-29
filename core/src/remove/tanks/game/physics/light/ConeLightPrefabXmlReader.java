package remove.tanks.game.physics.light;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.graphics.color.ColorPrefab;
import remove.tanks.game.graphics.color.ColorPrefabXmlReader;
import remove.tanks.game.graphics.color.RgbColorPrefab;
import remove.tanks.game.utility.surface.position.PositionPrefab;
import remove.tanks.game.utility.surface.position.PositionPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class ConeLightPrefabXmlReader implements SubLightPrefabXmlReader<ConeLightPrefab> {
    private static final String DISTANCE_ELEMENT = "distance";
    private static final String DIRECTION_DEGREE_ELEMENT = "directionDegree";
    private static final String CONE_DEGREE_ELEMENT = "coneDegree";
    private static final String X_RAY_ELEMENT = "xRay";

    private final PositionPrefabXmlReader positionPrefabXmlReader;
    private final ColorPrefabXmlReader colorPrefabXmlReader;

    public ConeLightPrefabXmlReader(
            PositionPrefabXmlReader positionPrefabXmlReader,
            ColorPrefabXmlReader colorPrefabXmlReader
    ) {
        this.positionPrefabXmlReader = positionPrefabXmlReader;
        this.colorPrefabXmlReader = colorPrefabXmlReader;
    }

    @Override
    public ConeLightPrefab readLightPrefab(XmlReader.Element element) {
        try {
            return new ConeLightPrefab(
                    readColorPrefab(element),
                    readPositionPrefab(element),
                    readDistance(element),
                    readDirectionDegree(element),
                    readConeDegree(element),
                    readXRay(element)
            );
        } catch (Exception e) {
            throw new LightPrefabXmlReadException(element, e);
        }
    }

    private ColorPrefab readColorPrefab(XmlReader.Element element) {
        if (element.getChildByName(ColorPrefabXmlReader.COLOR_ELEMENT) == null) {
            return RgbColorPrefab.WHITE;
        }
        return colorPrefabXmlReader.readColorPrefab(
                element.getChildByName(ColorPrefabXmlReader.COLOR_ELEMENT)
        );
    }

    private PositionPrefab readPositionPrefab(XmlReader.Element element) {
        return element.getChildByName(PositionPrefabXmlReader.POSITION_ELEMENT) == null
                ? PositionPrefab.POSITION_PREFAB_ZERO
                : positionPrefabXmlReader.readPositionPrefab(
                element.getChildByName(PositionPrefabXmlReader.POSITION_ELEMENT)
        );
    }

    private float readDistance(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(DISTANCE_ELEMENT).getText().trim());
    }

    private float readDirectionDegree(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(DIRECTION_DEGREE_ELEMENT).getText().trim());
    }

    private float readConeDegree(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(CONE_DEGREE_ELEMENT).getText().trim());
    }

    private boolean readXRay(XmlReader.Element element) {
        return Boolean.valueOf(element.getChildByName(X_RAY_ELEMENT).getText().trim());
    }

    @Override
    public LightType getReaderType() {
        return LightType.ConeLight;
    }
}
