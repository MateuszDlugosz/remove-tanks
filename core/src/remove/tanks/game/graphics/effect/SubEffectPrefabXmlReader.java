package remove.tanks.game.graphics.effect;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public interface SubEffectPrefabXmlReader<T extends EffectPrefab> {
    T readEffectPrefab(XmlReader.Element element);
    EffectType getReaderType();
}
