package remove.tanks.game.graphic.animation;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public interface RegistrableAnimationPrototypeXmlLoader<T extends AnimationPrototype> {
    T loadAnimationPrototype(XmlReader.Element element);
    AnimationType getLoaderType();
}
