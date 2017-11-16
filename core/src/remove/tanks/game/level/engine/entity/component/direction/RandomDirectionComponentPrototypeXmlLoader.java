package remove.tanks.game.level.engine.entity.component.direction;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;
import remove.tanks.game.level.engine.utility.direction.AvailableDirectionsXmlLoader;

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
        return new RandomDirectionComponentPrototype(
                Float.valueOf(element.getChildByName(CHANGE_DIRECTION_MIN_FREQUENCY_ELEMENT).getText().trim()),
                Float.valueOf(element.getChildByName(CHANGE_DIRECTION_MAX_FREQUENCY_ELEMENT).getText().trim()),
                availableDirectionsXmlLoader.loadAvailableDirections(
                        element.getChildByName(AvailableDirectionsXmlLoader.AVAILABLE_DIRECTIONS_ELEMENT)
                )
        );
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.RandomDirectionComponent;
    }
}
