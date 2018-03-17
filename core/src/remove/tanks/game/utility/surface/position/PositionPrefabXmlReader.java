package remove.tanks.game.utility.surface.position;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class PositionPrefabXmlReader {
    public static final String POSITION_ELEMENT = "position";
    public static final String POSITIONS_ELEMENT = "positions";

    private static final String X_ELEMENT = "x";
    private static final String Y_ELEMENT = "y";

    public List<PositionPrefab> readPositionPrefabs(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(POSITION_ELEMENT).toArray())
                .map(this::readPositionPrefab)
                .collect(Collectors.toList());
    }

    public PositionPrefab readPositionPrefab(XmlReader.Element element) {
        try {
            return new PositionPrefab(
                    readXPositionValue(element),
                    readYPositionValue(element)
            );
        } catch (Exception e) {
            throw new PositionPrefabXmlReadException(element, e);
        }
    }

    private Float readXPositionValue(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(X_ELEMENT).getText().trim());
    }

    private Float readYPositionValue(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(Y_ELEMENT).getText().trim());
    }
}
