package remove.tanks.game.physics.shape;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.utility.surface.position.PositionPrefab;
import remove.tanks.game.utility.surface.position.PositionPrefabXmlReader;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class PolygonShapePrefabXmlReader implements SubShapePrefabXmlReader<PolygonShapePrefab> {
    private final PositionPrefabXmlReader positionPrefabXmlReader;
    private final VertexPrefabXmlReader vertexPrefabXmlReader;

    public PolygonShapePrefabXmlReader(
            PositionPrefabXmlReader positionPrefabXmlReader,
            VertexPrefabXmlReader vertexPrefabXmlReader
    ) {
        this.positionPrefabXmlReader = positionPrefabXmlReader;
        this.vertexPrefabXmlReader = vertexPrefabXmlReader;
    }

    @Override
    public PolygonShapePrefab readShapePrefab(XmlReader.Element element) {
        try {
            return new PolygonShapePrefab(
                    readPositionPrefab(element),
                    readVerticesPrefabs(element)
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

    private List<VertexPrefab> readVerticesPrefabs(XmlReader.Element element) {
        return vertexPrefabXmlReader.readVerticesPrefabs(
                element.getChildByName(VertexPrefabXmlReader.VERTICES_ELEMENT)
        );
    }

    @Override
    public ShapeType getReaderType() {
        return ShapeType.PolygonShape;
    }
}