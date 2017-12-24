package remove.tanks.game.level.event.points;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EventPrototypeXmlLoadException;
import remove.tanks.game.level.event.EventType;
import remove.tanks.game.level.event.RegistrableEventPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class IncreasePointsMultiplierEventPrototypeXmlLoader
        implements RegistrableEventPrototypeXmlLoader<IncreasePointsMultiplierEventPrototype>
{
    @Override
    public IncreasePointsMultiplierEventPrototype loadEventPrototype(XmlReader.Element element) {
        try {
            return new IncreasePointsMultiplierEventPrototype();
        } catch (Exception e) {
            throw new EventPrototypeXmlLoadException(element, e);
        }
    }

    @Override
    public EventType getLoaderType() {
        return EventType.IncreasePointsMultiplierEvent;
    }
}
