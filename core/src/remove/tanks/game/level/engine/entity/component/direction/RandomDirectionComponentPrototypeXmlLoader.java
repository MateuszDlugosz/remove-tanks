package remove.tanks.game.level.engine.entity.component.direction;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrototypeXmlLoadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;
import remove.tanks.game.level.engine.utility.direction.AvailableDirectionsXmlLoader;
import remove.tanks.game.level.engine.utility.direction.Direction;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class RandomDirectionComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<RandomDirectionComponentPrototype>
{
    private static final String CHANGE_DIRECTION_MIN_FREQUENCY_ELEMENT
            = "changeDirectionMinFrequency";
    private static final String CHANGE_DIRECTION_MAX_FREQUENCY_ELEMENT
            = "changeDirectionMaxFrequency";

    private final AvailableDirectionsXmlLoader availableDirectionsXmlLoader;

    public RandomDirectionComponentPrototypeXmlLoader(AvailableDirectionsXmlLoader availableDirectionsXmlLoader) {
        this.availableDirectionsXmlLoader = availableDirectionsXmlLoader;
    }

    @Override
    public RandomDirectionComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        try {
            return new RandomDirectionComponentPrototype(
                    loadChangeDirectionMinFrequency(element),
                    loadChangeDirectionMaxFrequency(element),
                    loadAvailableDirections(element)
            );
        } catch (Exception e) {
            throw new ComponentPrototypeXmlLoadException(element, e);
        }
    }

    private float loadChangeDirectionMinFrequency(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(CHANGE_DIRECTION_MIN_FREQUENCY_ELEMENT).getText().trim());
    }

    private float loadChangeDirectionMaxFrequency(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(CHANGE_DIRECTION_MAX_FREQUENCY_ELEMENT).getText().trim());
    }

    private List<Direction> loadAvailableDirections(XmlReader.Element element) {
        return availableDirectionsXmlLoader.loadAvailableDirections(
                element.getChildByName(AvailableDirectionsXmlLoader.AVAILABLE_DIRECTIONS_ELEMENT)
        );
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.RandomDirectionComponent;
    }
}
