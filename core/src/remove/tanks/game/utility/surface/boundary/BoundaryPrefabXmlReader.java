package remove.tanks.game.utility.surface.boundary;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class BoundaryPrefabXmlReader {
    public static final String BOUNDARIES_ELEMENT = "boundaries";
    public static final String BOUNDARY_ELEMENT = "boundary";

    private static final String MIN_X_ELEMENT = "minX";
    private static final String MAX_X_ELEMENT = "maxX";
    private static final String MIN_Y_ELEMENT = "minY";
    private static final String MAX_Y_ELEMENT = "maxY";

    public List<BoundaryPrefab> readBoundaryPrefabs(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(BOUNDARY_ELEMENT).toArray())
                .map(this::readBoundaryPrefab)
                .collect(Collectors.toList());
    }

    public BoundaryPrefab readBoundaryPrefab(XmlReader.Element element) {
        try {
            return new BoundaryPrefab(
                    readMinX(element),
                    readMaxX(element),
                    readMinY(element),
                    readMaxY(element)
            );
        } catch (Exception e) {
            throw new BoundaryPrefabXmlReadException(element, e);
        }
    }

    private float readMinX(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(MIN_X_ELEMENT).getText().trim());
    }

    private float readMaxX(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(MAX_X_ELEMENT).getText().trim());
    }

    private float readMinY(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(MIN_Y_ELEMENT).getText().trim());
    }

    private float readMaxY(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(MAX_Y_ELEMENT).getText().trim());
    }
}
