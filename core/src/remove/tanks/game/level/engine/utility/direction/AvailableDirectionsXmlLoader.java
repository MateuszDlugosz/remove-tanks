package remove.tanks.game.level.engine.utility.direction;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class AvailableDirectionsXmlLoader {
    public static final String AVAILABLE_DIRECTIONS_ELEMENT
            = "availableDirections";

    private final DirectionXmlLoader directionXmlLoader;

    public AvailableDirectionsXmlLoader(DirectionXmlLoader directionXmlLoader) {
        this.directionXmlLoader = directionXmlLoader;
    }

    public List<Direction> loadAvailableDirections(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(DirectionXmlLoader.DIRECTION_ELEMENT).toArray())
                .map(e -> directionXmlLoader.loadDirection(e))
                .collect(Collectors.toList());
    }
}
