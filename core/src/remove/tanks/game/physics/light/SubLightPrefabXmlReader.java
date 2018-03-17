package remove.tanks.game.physics.light;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public interface SubLightPrefabXmlReader<T extends LightPrefab> {
    T readLightPrefab(XmlReader.Element element);
    LightType getReaderType();
}