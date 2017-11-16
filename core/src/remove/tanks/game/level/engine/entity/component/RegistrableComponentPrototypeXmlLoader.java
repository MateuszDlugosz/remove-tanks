package remove.tanks.game.level.engine.entity.component;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public interface RegistrableComponentPrototypeXmlLoader<T extends ComponentPrototype> {
    T loadComponentPrototype(XmlReader.Element element);
    ComponentType getLoaderType();
}
