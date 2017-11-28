package remove.tanks.game.level.event;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public interface RegistrableEventPrototypeXmlLoader<T extends EventPrototype> {
    T loadEventPrototype(XmlReader.Element element);
    EventType getLoaderType();
}
