package remove.tanks.game.level.engine.entity.component;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public interface SubComponentPrefabXmlReader<T extends ComponentPrefab> {
    T readComponentPrefab(XmlReader.Element element);
    ComponentType getReaderType();
}
