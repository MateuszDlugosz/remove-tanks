package remove.tanks.game.physics.shape;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.utility.surface.position.PositionPrefab;
import remove.tanks.game.utility.surface.position.PositionPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class RectangleShapePrefabXmlReader implements SubShapePrefabXmlReader<RectangleShapePrefab> {
    private static final String WIDTH_ELEMENT = "width";
    private static final String HEIGHT_ELEMENT = "height";

    private final PositionPrefabXmlReader positionPrefabXmlReader;

    public RectangleShapePrefabXmlReader(PositionPrefabXmlReader positionPrefabXmlReader) {
        this.positionPrefabXmlReader = positionPrefabXmlReader;
    }

    @Override
    public RectangleShapePrefab readShapePrefab(XmlReader.Element element) {
        try {
            return new RectangleShapePrefab(
                    readPositionPrefab(element),
                    readWidth(element),
                    readHeight(element)
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

    private float readWidth(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(WIDTH_ELEMENT).getText());
    }

    private float readHeight(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(HEIGHT_ELEMENT).getText());
    }

    @Override
    public ShapeType getReaderType() {
        return ShapeType.RectangleShape;
    }
}
