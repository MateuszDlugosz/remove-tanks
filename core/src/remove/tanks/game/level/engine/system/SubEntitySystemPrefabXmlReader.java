package remove.tanks.game.level.engine.system;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public interface SubEntitySystemPrefabXmlReader<T extends EntitySystemPrefab> {
    T readEntitySystemPrefab(XmlReader.Element element, int priority);
    SystemType getReaderType();
}