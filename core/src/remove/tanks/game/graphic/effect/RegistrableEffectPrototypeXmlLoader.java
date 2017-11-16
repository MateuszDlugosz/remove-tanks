package remove.tanks.game.graphic.effect;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public interface RegistrableEffectPrototypeXmlLoader<T extends EffectPrototype> {
    T loadEffectPrototype(XmlReader.Element element);
    EffectType getLoaderType();
}
