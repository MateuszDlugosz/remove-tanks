package remove.tanks.game.level.event.destroy;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EventType;
import remove.tanks.game.level.event.RegistrableEventPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class DestroyEntityByIdEventPrototypeXmlLoader
        implements RegistrableEventPrototypeXmlLoader<DestroyEntityByIdEventPrototype>
{
    private static final String ID_ELEMENT = "id";

    @Override
    public DestroyEntityByIdEventPrototype loadEventPrototype(XmlReader.Element element) {
        return new DestroyEntityByIdEventPrototype(element.getChildByName(ID_ELEMENT).getText().trim());
    }

    @Override
    public EventType getLoaderType() {
        return EventType.DestroyEntityByIdEvent;
    }
}
