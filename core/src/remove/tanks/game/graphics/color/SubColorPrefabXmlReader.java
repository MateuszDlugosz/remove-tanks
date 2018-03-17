package remove.tanks.game.graphics.color;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public interface SubColorPrefabXmlReader<T extends ColorPrefab> {
    T readColorPrefab(XmlReader.Element element);
    ColorType getReaderType();
}
