package remove.tanks.game.graphics.view;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
@SuppressWarnings("unchecked")
public final class ViewPrefabXmlReader {
    public static final String VIEW_ELEMENT = "view";
    public static final String VIEWS_ELEMENT = "views";

    private static final String TYPE_ATTRIBUTE = "type";

    private final Map<ViewType, SubViewPrefabXmlReader> readers
            = new EnumMap<>(ViewType.class);

    public ViewPrefabXmlReader(SubViewPrefabXmlReader[] readers) {
        Arrays.stream(readers).forEach(s -> this.readers.put(s.getReaderType(), s));
    }

    public List<ViewPrefab> readViewPrefabs(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(VIEW_ELEMENT).toArray())
                .map(this::readViewPrefab)
                .collect(Collectors.toList());
    }

    public ViewPrefab readViewPrefab(XmlReader.Element element) {
        try {
            ViewType type = ViewType.valueOf(element.getAttribute(TYPE_ATTRIBUTE).trim());
            if (!readers.containsKey(type)) {
                throw new ViewPrefabReaderNotFoundException(type);
            }
            return readers.get(type).readViewPrefab(element);
        } catch (Exception e) {
            throw new ViewPrefabXmlReadException(element, e);
        }
    }
}
