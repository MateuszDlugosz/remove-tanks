package remove.tanks.game.level.event.spawner;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EventType;
import remove.tanks.game.level.event.RegistrableEventPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class ActivateAutoSpawnerEventPrototypeXmlLoader
        implements RegistrableEventPrototypeXmlLoader<ActivateAutoSpawnerEventPrototype>
{
    private static final String ID_ELEMENT = "id";

    @Override
    public ActivateAutoSpawnerEventPrototype loadEventPrototype(XmlReader.Element element) {
        return new ActivateAutoSpawnerEventPrototype(element.getChildByName(ID_ELEMENT).getText().trim());
    }

    @Override
    public EventType getLoaderType() {
        return EventType.ActivateSpawnerEvent;
    }
}
