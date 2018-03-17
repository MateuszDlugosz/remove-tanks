package remove.tanks.game.level.event;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public interface SubEntityEventPrefabXmlReader<T extends EntityEventPrefab> {
    T readEntityEventPrefab(XmlReader.Element element);
    EntityEventType getReaderType();
}
