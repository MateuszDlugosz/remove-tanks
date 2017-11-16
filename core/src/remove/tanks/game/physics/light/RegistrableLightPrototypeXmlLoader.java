package remove.tanks.game.physics.light;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public interface RegistrableLightPrototypeXmlLoader<T extends LightPrototype> {
    T loadLightPrototype(XmlReader.Element element);
    LightType getLoaderType();
}
