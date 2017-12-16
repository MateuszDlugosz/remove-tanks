package remove.tanks.game.level.event.destroy;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EventType;
import remove.tanks.game.level.event.RegistrableEventPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class DestroyAllEnemiesEventPrototypeXmlLoader
        implements RegistrableEventPrototypeXmlLoader<DestroyAllEnemiesEventPrototype>
{
    @Override
    public DestroyAllEnemiesEventPrototype loadEventPrototype(XmlReader.Element element) {
        return new DestroyAllEnemiesEventPrototype();
    }

    @Override
    public EventType getLoaderType() {
        return EventType.DestroyAllEnemiesEvent;
    }
}
