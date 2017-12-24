package remove.tanks.game.level.event.enemy;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EventPrototypeXmlLoadException;
import remove.tanks.game.level.event.EventType;
import remove.tanks.game.level.event.RegistrableEventPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class DecreaseEnemiesCounterEventPrototypeXmlLoader
        implements RegistrableEventPrototypeXmlLoader<DecreaseEnemiesCounterEventPrototype>
{
    @Override
    public DecreaseEnemiesCounterEventPrototype loadEventPrototype(XmlReader.Element element) {
        try {
            return new DecreaseEnemiesCounterEventPrototype();
        } catch (Exception e) {
            throw new EventPrototypeXmlLoadException(element, e);
        }
    }

    @Override
    public EventType getLoaderType() {
        return EventType.DecreaseEnemiesCounterEvent;
    }
}
