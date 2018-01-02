package remove.tanks.game.level.engine.system.hud.stages.widget.time;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.hud.stages.widget.RegistrableWidgetPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.hud.stages.widget.WidgetPrototypeXmlLoadException;
import remove.tanks.game.level.engine.system.hud.stages.widget.WidgetType;

/**
 * @author Mateusz Długosz
 */
public final class TimeLeftPresenterWidgetPrototypeXmlLoader
        implements RegistrableWidgetPrototypeXmlLoader<TimeLeftPresenterWidgetPrototype>
{
    @Override
    public TimeLeftPresenterWidgetPrototype loadWidgetPrototype(XmlReader.Element element) {
        try {
            return new TimeLeftPresenterWidgetPrototype();
        } catch (Exception e) {
            throw new WidgetPrototypeXmlLoadException(element, e);
        }
    }

    @Override
    public WidgetType getLoaderType() {
        return WidgetType.TimeLeftPresenterWidget;
    }
}
