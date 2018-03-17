package remove.tanks.game.graphics.animation;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public interface SubAnimationPrefabXmlReader<T extends AnimationPrefab> {
    T readAnimationPrefab(XmlReader.Element element);
    AnimationType getReaderType();
}
