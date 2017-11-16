package remove.tanks.game.physics.shape;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.utility.position.PositionPrototype;
import remove.tanks.game.utility.position.PositionPrototypeXmlLoader;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class PolygonShapePrototypeXmlLoader
        implements RegistrableShapePrototypeXmlLoader<PolygonShapePrototype>
{
    private final PositionPrototypeXmlLoader positionPrototypeXmlLoader;
    private final VertexPrototypeXmlLoader vertexPrototypeXmlLoader;

    public PolygonShapePrototypeXmlLoader(
            PositionPrototypeXmlLoader positionPrototypeXmlLoader,
            VertexPrototypeXmlLoader vertexPrototypeXmlLoader
    ) {
        this.positionPrototypeXmlLoader = positionPrototypeXmlLoader;
        this.vertexPrototypeXmlLoader = vertexPrototypeXmlLoader;
    }

    @Override
    public PolygonShapePrototype loadShapePrototype(XmlReader.Element element) {
        try {
            return new PolygonShapePrototype(
                    loadPositionPrototype(element),
                    loadVerticesPrototypes(element)
            );
        } catch (Exception e) {
            throw new ShapePrototypeXmlLoadException(element, e);
        }
    }

    private PositionPrototype loadPositionPrototype(XmlReader.Element element) {
        return element.getChildByName(PositionPrototypeXmlLoader.POSITION_ELEMENT) == null
                ? new PositionPrototype(0,0)
                : positionPrototypeXmlLoader.loadPositionPrototype(
                element.getChildByName(PositionPrototypeXmlLoader.POSITION_ELEMENT)
        );
    }

    private List<VertexPrototype> loadVerticesPrototypes(XmlReader.Element element) {
        return vertexPrototypeXmlLoader.loadVerticesPrototypes(
                element.getChildByName(VertexPrototypeXmlLoader.VERTICES_ELEMENT)
        );
    }

    @Override
    public ShapeType getLoaderType() {
        return ShapeType.PolygonShape;
    }
}
