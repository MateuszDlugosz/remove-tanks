package remove.tanks.game.level.engine.listener;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public interface RegistrableEntityListenerPrototypeXmlLoader<T extends EntityListenerPrototype> {
    T loadEntityListenerPrototype(XmlReader.Element element, int priority);
    ListenerType getLoaderType();
}
