package remove.tanks.game.level.engine.system.hud.stages.widget.points;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.hud.stages.widget.RegistrableWidgetPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.hud.stages.widget.WidgetPrototypeXmlLoadException;
import remove.tanks.game.level.engine.system.hud.stages.widget.WidgetType;

/**
 * @author Mateusz Długosz
 */
public final class PointsPresenterWidgetPrototypeXmlLoader
        implements RegistrableWidgetPrototypeXmlLoader<PointsPresenterWidgetPrototype>
{
    @Override
    public PointsPresenterWidgetPrototype loadWidgetPrototype(XmlReader.Element element) {
        try {
            return new PointsPresenterWidgetPrototype();
        } catch (Exception e) {
            throw new WidgetPrototypeXmlLoadException(element, e);
        }
    }

    @Override
    public WidgetType getLoaderType() {
        return WidgetType.PointsPresenterWidget;
    }
}
