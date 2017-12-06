package remove.tanks.game.level.event.life;

import com.badlogic.gdx.utils.XmlReader;
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
        return new RemoveLifeEventPrototype();
    }

    @Override
    public EventType getLoaderType() {
        return EventType.RemoveLifeEvent;
    }
}
