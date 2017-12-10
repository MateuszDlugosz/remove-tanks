package remove.tanks.game.level.engine.system;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public interface RegistrableEntitySystemPrototypeXmlLoader<T extends EntitySystemPrototype> {
    T loadEntitySystemPrototype(XmlReader.Element element, int priority);
    SystemType getLoaderType();
}
