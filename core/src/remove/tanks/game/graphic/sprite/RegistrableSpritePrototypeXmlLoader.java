package remove.tanks.game.graphic.sprite;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public interface RegistrableSpritePrototypeXmlLoader<T extends SpritePrototype> {
    T loadSpritePrototype(XmlReader.Element element);
    SpriteType getLoaderType();
}
