package remove.tanks.game.graphic.view;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public interface RegistrableViewPrototypeXmlLoader<T extends ViewPrototype> {
    T loadViewPrototype(XmlReader.Element element);
    ViewType getLoaderType();
}
