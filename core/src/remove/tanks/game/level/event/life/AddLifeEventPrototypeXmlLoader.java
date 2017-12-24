package remove.tanks.game.level.event.life;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EventPrototypeXmlLoadException;
import remove.tanks.game.level.event.EventType;
import remove.tanks.game.level.event.RegistrableEventPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class AddLifeEventPrototypeXmlLoader
        implements RegistrableEventPrototypeXmlLoader<AddLifeEventPrototype>
{
    @Override
    public AddLifeEventPrototype loadEventPrototype(XmlReader.Element element) {
        try {
            return new AddLifeEventPrototype();
        } catch (Exception e) {
            throw new EventPrototypeXmlLoadException(element, e);
        }
    }

    @Override
    public EventType getLoaderType() {
        return EventType.AddLifeEvent;
    }
}
