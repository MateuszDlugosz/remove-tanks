package remove.tanks.game.level.engine.system.hud.stages.widget;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public interface RegistrableWidgetPrototypeXmlLoader<T extends WidgetPrototype> {
    T loadWidgetPrototype(XmlReader.Element element);
    WidgetType getLoaderType();
}
