package remove.tanks.game.graphic.color;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public interface RegistrableColorPrototypeXmlLoader<T extends ColorPrototype> {
    T loadColorPrototype(XmlReader.Element element);
    ColorType getLoaderType();
}
