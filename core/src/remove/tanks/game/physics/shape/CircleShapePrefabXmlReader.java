package remove.tanks.game.physics.shape;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.utility.surface.position.PositionPrefab;
import remove.tanks.game.utility.surface.position.PositionPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class CircleShapePrefabXmlReader implements SubShapePrefabXmlReader<CircleShapePrefab> {
    private static final String RADIUS_ELEMENT = "radius";

    private final PositionPrefabXmlReader positionPrefabXmlReader;

    public CircleShapePrefabXmlReader(PositionPrefabXmlReader positionPrefabXmlReader) {
        this.positionPrefabXmlReader = positionPrefabXmlReader;
    }

    @Override
    public CircleShapePrefab readShapePrefab(XmlReader.Element element) {
        try {
            return new CircleShapePrefab(
                    readPositionPrefab(element),
                    readRadius(element)
            );
        } catch (Exception e) {
            throw new ShapePrefabXmlReadException(element, e);
        }
    }

    private PositionPrefab readPositionPrefab(XmlReader.Element element) {
        return element.getChildByName(PositionPrefabXmlReader.POSITION_ELEMENT) == null
                ? PositionPrefab.POSITION_PREFAB_ZERO
                : positionPrefabXmlReader.readPositionPrefab(
                element.getChildByName(PositionPrefabXmlReader.POSITION_ELEMENT)
        );
    }

    private float readRadius(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(RADIUS_ELEMENT).getText());
    }

    @Override
    public ShapeType getReaderType() {
        return ShapeType.CircleShape;
    }
}
