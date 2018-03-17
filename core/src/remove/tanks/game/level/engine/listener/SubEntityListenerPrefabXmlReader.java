package remove.tanks.game.level.engine.listener;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public interface SubEntityListenerPrefabXmlReader<T extends EntityListenerPrefab> {
    T readEntityListenerPrefab(XmlReader.Element element, int priority);
    ListenerType getReaderType();
}
