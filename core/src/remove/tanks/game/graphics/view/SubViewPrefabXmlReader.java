package remove.tanks.game.graphics.view;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public interface SubViewPrefabXmlReader<T extends ViewPrefab> {
    T readViewPrefab(XmlReader.Element element);
    ViewType getReaderType();
}
