package remove.tanks.game.level.utility.stage.widget;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public interface SubWidgetPrefabXmlReader<T extends WidgetPrefab> {
    T readWidgetPrefab(XmlReader.Element element);
    WidgetType getReaderType();
}
