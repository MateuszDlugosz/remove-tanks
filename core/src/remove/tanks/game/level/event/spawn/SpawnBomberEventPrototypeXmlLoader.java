package remove.tanks.game.level.event.spawn;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EventType;
import remove.tanks.game.level.event.RegistrableEventPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class SpawnBomberEventPrototypeXmlLoader
        implements RegistrableEventPrototypeXmlLoader<SpawnBomberEventPrototype>
{
    @Override
    public SpawnBomberEventPrototype loadEventPrototype(XmlReader.Element element) {
        return new SpawnBomberEventPrototype();
    }

    @Override
    public EventType getLoaderType() {
        return EventType.SpawnBomberEvent;
    }
}
