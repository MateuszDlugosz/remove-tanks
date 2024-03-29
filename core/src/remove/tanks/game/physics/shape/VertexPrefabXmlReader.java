package remove.tanks.game.physics.shape;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class VertexPrefabXmlReader {
    public static final String VERTEX_ELEMENT = "vertex";
    public static final String VERTICES_ELEMENT = "vertices";

    private static final String X_ATTRIBUTE = "x";
    private static final String Y_ATTRIBUTE = "y";

    public List<VertexPrefab> readVerticesPrefabs(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(VERTEX_ELEMENT).toArray())
                .map(this::readVertexPrefab)
                .collect(Collectors.toList());
    }

    public VertexPrefab readVertexPrefab(XmlReader.Element element) {
        try {
            return new VertexPrefab(
                    element.getFloat(X_ATTRIBUTE),
                    element.getFloat(Y_ATTRIBUTE)
            );
        } catch (Exception e) {
            throw new VertexPrefabXmlReadException(element, e);
        }
    }
}
