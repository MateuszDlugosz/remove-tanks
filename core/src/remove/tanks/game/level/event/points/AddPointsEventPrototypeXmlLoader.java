package remove.tanks.game.level.event.points;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EventType;
import remove.tanks.game.level.event.RegistrableEventPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class AddPointsEventPrototypeXmlLoader
        implements RegistrableEventPrototypeXmlLoader<AddPointsEventPrototype>
{
    private static final String POINTS_ELEMENT = "points";

    @Override
    public AddPointsEventPrototype loadEventPrototype(XmlReader.Element element) {
        return new AddPointsEventPrototype(
                Integer.valueOf(element.getChildByName(POINTS_ELEMENT).getText())
        );
    }

    @Override
    public EventType getLoaderType() {
        return EventType.AddPointsEvent;
    }
}
