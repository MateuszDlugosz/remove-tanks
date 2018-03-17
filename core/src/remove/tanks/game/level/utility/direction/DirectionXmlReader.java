package remove.tanks.game.level.utility.direction;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class DirectionXmlReader {
    public static final String DIRECTION_ELEMENT = "direction";
    public static final String DIRECTIONS_ELEMENT = "directions";

    public List<Direction> readDirections(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(DIRECTION_ELEMENT).toArray())
                .map(this::readDirection)
                .collect(Collectors.toList());
    }

    public Direction readDirection(XmlReader.Element element) {
        try {
            return Direction.valueOf(element.getText().trim());
        } catch (Exception e) {
            throw new DirectionXmlReadException(element, e);
        }
    }
}
