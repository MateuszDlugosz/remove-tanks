package remove.tanks.game.level.event.ammo;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EventPrototypeXmlLoadException;
import remove.tanks.game.level.event.EventType;
import remove.tanks.game.level.event.RegistrableEventPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class AmmoUpEventPrototypeXmlLoader
        implements RegistrableEventPrototypeXmlLoader<AmmoUpEventPrototype>
{
    @Override
    public AmmoUpEventPrototype loadEventPrototype(XmlReader.Element element) {
        try {
            return new AmmoUpEventPrototype();
        } catch (Exception e) {
            throw new EventPrototypeXmlLoadException(element, e);
        }
    }

    @Override
    public EventType getLoaderType() {
        return EventType.AmmoUpEvent;
    }
}
