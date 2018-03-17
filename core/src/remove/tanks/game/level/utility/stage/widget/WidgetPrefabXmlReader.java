package remove.tanks.game.level.utility.stage.widget;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class WidgetPrefabXmlReader {
    public static final String WIDGET_ELEMENT = "widget";
    public static final String WIDGETS_ELEMENT = "widgets";

    private static final String TYPE_ATTRIBUTE = "type";

    private final Map<WidgetType, SubWidgetPrefabXmlReader> reader
            = new HashMap<>();

    public WidgetPrefabXmlReader(SubWidgetPrefabXmlReader[] reader) {
        Arrays.stream(reader).forEach(l -> this.reader.put(l.getReaderType(), l));
    }

    public List<WidgetPrefab> readWidgetPrefabs(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(WIDGET_ELEMENT).toArray())
                .map(this::readWidgetPrefab)
                .collect(Collectors.toList());
    }

    public WidgetPrefab readWidgetPrefab(XmlReader.Element element) {
        try {
            WidgetType type = WidgetType.valueOf(element.getAttribute(TYPE_ATTRIBUTE).trim());
            if (!reader.containsKey(type)) {
                throw new WidgetPrefabReaderNotFoundException(type);
            }
            return reader.get(type).readWidgetPrefab(element);
        } catch (Exception e) {
            throw new WidgetPrefabXmlReadException(element, e);
        }
    }
}
