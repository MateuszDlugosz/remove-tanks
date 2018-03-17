package remove.tanks.game.level.event;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public interface SubEventPrefabXmlReader<T extends EventPrefab> {
    T readEventPrefab(XmlReader.Element element);
    EventType getReaderType();
}
