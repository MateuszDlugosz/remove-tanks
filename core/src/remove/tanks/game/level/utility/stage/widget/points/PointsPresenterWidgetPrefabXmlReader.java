package remove.tanks.game.level.utility.stage.widget.points;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.utility.stage.widget.SubWidgetPrefabXmlReader;
import remove.tanks.game.level.utility.stage.widget.WidgetPrefabXmlReadException;
import remove.tanks.game.level.utility.stage.widget.WidgetType;

/**
 * @author Mateusz Długosz
 */
public final class PointsPresenterWidgetPrefabXmlReader implements SubWidgetPrefabXmlReader<PointsPresenterWidgetPrefab> {
    @Override
    public PointsPresenterWidgetPrefab readWidgetPrefab(XmlReader.Element element) {
        try {
            return new PointsPresenterWidgetPrefab();
        } catch (Exception e) {
            throw new WidgetPrefabXmlReadException(element, e);
        }
    }

    @Override
    public WidgetType getReaderType() {
        return WidgetType.PointsPresenterWidget;
    }
}
