package remove.tanks.game.level.event.life;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EventPrototypeXmlLoadException;
import remove.tanks.game.level.event.EventType;
import remove.tanks.game.level.event.RegistrableEventPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class RemoveLifeEventPrototypeXmlLoader
        implements RegistrableEventPrototypeXmlLoader<RemoveLifeEventPrototype>
{
    @Override
    public RemoveLifeEventPrototype loadEventPrototype(XmlReader.Element element) {
        try {
            return new RemoveLifeEventPrototype();
        } catch (Exception e) {
            throw new EventPrototypeXmlLoadException(element, e);
        }
    }

    @Override
    public EventType getLoaderType() {
        return EventType.RemoveLifeEvent;
    }
}
