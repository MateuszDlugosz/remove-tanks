package remove.tanks.game.graphics.sprite;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public interface SubSpritePrefabXmlReader<T extends SpritePrefab> {
    T readSpritePrefab(XmlReader.Element element);
    SpriteType getReaderType();
}
