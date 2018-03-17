package remove.tanks.game.level.engine.entity.component.direction;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.SubComponentPrefabXmlReader;
import remove.tanks.game.level.utility.direction.Direction;
import remove.tanks.game.level.utility.direction.DirectionXmlReader;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class RandomDirectionComponentPrefabXmlReader implements SubComponentPrefabXmlReader<RandomDirectionComponentPrefab> {
    private static final String MIN_CHANGE_DIRECTION_FREQUENCY_ELEMENT = "minChangeDirectionFrequency";
    private static final String MAX_CHANGE_DIRECTION_FREQUENCY_ELEMENT = "maxChangeDirectionFrequency";

    private final DirectionXmlReader directionXmlReader;

    public RandomDirectionComponentPrefabXmlReader(DirectionXmlReader directionXmlReader) {
        this.directionXmlReader = directionXmlReader;
    }

    @Override
    public RandomDirectionComponentPrefab readComponentPrefab(XmlReader.Element element) {
        try {
            return new RandomDirectionComponentPrefab(
                    readMinChangeDirectionFrequency(element),
                    readMaxChangeDirectionFrequency(element),
                    readDirections(element)
            );
        } catch (Exception e) {
            throw new ComponentPrefabXmlReadException(element, e);
        }
    }

    private float readMinChangeDirectionFrequency(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(MIN_CHANGE_DIRECTION_FREQUENCY_ELEMENT).getText().trim());
    }

    private float readMaxChangeDirectionFrequency(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(MAX_CHANGE_DIRECTION_FREQUENCY_ELEMENT).getText().trim());
    }

    private List<Direction> readDirections(XmlReader.Element element) {
        return directionXmlReader.readDirections(element.getChildByName(DirectionXmlReader.DIRECTIONS_ELEMENT));
    }

    @Override
    public ComponentType getReaderType() {
        return ComponentType.RandomDirectionComponent;
    }
}
