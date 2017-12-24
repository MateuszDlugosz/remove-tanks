package remove.tanks.game.level.event.spawner;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EventPrototypeXmlLoadException;
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
        try {
            return new ActivateAutoSpawnerEventPrototype(
                    loadId(element)
            );
        } catch (Exception e) {
            throw new EventPrototypeXmlLoadException(element, e);
        }
    }

    private String loadId(XmlReader.Element element) {
        return element.getChildByName(ID_ELEMENT).getText().trim();
    }

    @Override
    public EventType getLoaderType() {
        return EventType.ActivateAutoSpawnerEvent;
    }
}
