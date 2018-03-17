package remove.tanks.game.level.utility.stage.widget.time;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.utility.stage.widget.SubWidgetPrefabXmlReader;
import remove.tanks.game.level.utility.stage.widget.WidgetPrefabXmlReadException;
import remove.tanks.game.level.utility.stage.widget.WidgetType;

/**
 * @author Mateusz Długosz
 */
public final class TimeLeftPresenterWidgetPrefabXmlReader implements SubWidgetPrefabXmlReader<TimeLeftPresenterWidgetPrefab> {
    @Override
    public TimeLeftPresenterWidgetPrefab readWidgetPrefab(XmlReader.Element element) {
        try {
            return new TimeLeftPresenterWidgetPrefab();
        } catch (Exception e) {
            throw new WidgetPrefabXmlReadException(element, e);
        }
    }

    @Override
    public WidgetType getReaderType() {
        return WidgetType.TimeLeftPresenterWidget;
    }
}
